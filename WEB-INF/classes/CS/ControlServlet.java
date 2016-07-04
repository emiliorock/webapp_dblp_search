package CS;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

@WebServlet(name = "ControlServlet", urlPatterns = "/control")

public class ControlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ControlServlet() {
		super();
	}

	/*** The doGet method will be used for updating shopping cart ***/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// first, initialize a new cart
		ArrayList<String> cart = new ArrayList();
		String op = (String) request.getParameter("op");

		// Add items to cart
		if (op.equals("add")) {
			String[] addlist = (String[]) request.getParameterValues("additems");
			ArrayList<String> newcart = (ArrayList) request.getSession().getAttribute("cart");

			if (addlist != null) {
				for (int i = 0; i < addlist.length; i++) {
					int flag = 0;
					if (newcart != null) {
						for (int j = 0; j < newcart.size(); j++) {
							if (addlist[i].equals(newcart.get(j)))
								flag = 1;
						}
					}
					if (flag == 0)
						newcart.add(addlist[i]);
				}
			}
			request.getSession().setAttribute("cart", newcart);
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		}

		// Delete items from cart
		else if (op.equals("del")) {
			String[] dellist = (String[]) request.getParameterValues("delitems");
			ArrayList<String> newcart = (ArrayList) request.getSession().getAttribute("cart");
			if (dellist.length != 0 && newcart.size() != 0) {
				int len = newcart.size();
				for (int i = 0; i < len; i++) {
					for (int j = 0; j < dellist.length; j++) {
						if (newcart.get(i).equals(dellist[j])) {
							newcart.remove(i);
							len--;
							i--;
						}
					}
				}
			}
			request.getSession().setAttribute("cart", newcart);
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		}
	}

	/*** The doPost method will be used for basic and advanced search ***/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Publication> list = new ArrayList();
		ArrayList<Publication> list1 = new ArrayList();
		ArrayList<Publication> list2 = new ArrayList();

		String action = request.getParameter("action");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String year = request.getParameter("year");
		String isbn = request.getParameter("isbn");
		String booktitle = request.getParameter("booktitle");
		String publisher = request.getParameter("publisher");

		// start parsing the xml file
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		File f = new File("F:\\sampledblp.xml");
		PublicationSax publications = new PublicationSax();
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		}
		try {
			parser.parse(f, publications);
		} catch (SAXException e) {
			e.printStackTrace();
		}
		ArrayList<Publication> pubs = publications.getPubs();

		if (action.equals("basic")) {
			basic_search(pubs, list, type, title, author, year);
		} else if (action.equals("advanced")) {
			if (isbn == "" && booktitle == "" && publisher == "") {
				basic_search(pubs, list, type, title, author, year);
			} else if (title == "" && author == "" && year == "") {
				advanced_search(pubs, list, type, booktitle, isbn, publisher);
			} else {
				basic_search(pubs, list1, type, title, author, year);
				advanced_search(pubs, list2, type, booktitle, isbn, publisher);
				intersect(list1, list2, list);
			}
		}
		request.getSession().setAttribute("results", list);
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

	// intersect of 2 lists
	public void intersect(ArrayList<Publication> list1, ArrayList<Publication> list2, ArrayList<Publication> list3) {
		for (Publication pub1 : list1) {
			for (Publication pub2 : list2) {
				if (pub1.title == null || pub2.title == null)
					continue;
				if (pub1.title.equals(pub2.title))
					list3.add(pub1);
			}
		}
	}

	// basic search method
	public void basic_search(ArrayList<Publication> pubs, ArrayList<Publication> list, String type, String title,
			String author, String year) {

		for (Publication pub : pubs) {
			if (pub.type.equals(type)) {
				if (title != "") {
					if (author != "") {
						if (year != "") {
							if (pub.title != null && pub.author != null && pub.year != null && pub.title.contains(title) && pub.author.contains(author) && pub.year.equals(year))
								list.add(pub);
							else
								continue;
						} else {
							if (pub.title != null && pub.author != null &&pub.title.contains(title) && pub.author.contains(author))
								list.add(pub);
							else
								continue;
						}
					} else {
						if (year != "") {
							if (pub.title != null && pub.year != null && pub.title.contains(title) && pub.year.equals(year))
								list.add(pub);
							else
								continue;
						} else {
							if (pub.title != null && pub.title.contains(title))
								list.add(pub);
							else
								continue;
						}
					}
				} else {
					if (author != "") {
						if (year != "") {
							if (pub.author != null && pub.year != null && pub.author.contains(author) && pub.year.equals(year))
								list.add(pub);
							else
								continue;
						} else {
							if (pub.author != null && pub.author.contains(author)) {
								list.add(pub);
							} else
								continue;
						}
					} else {
						if (year != "") {
							if (pub.year != null && pub.year.equals(year)) {
								list.add(pub);
							}
						} else {
							continue;
						}
					}
				}
			} else
				continue;
		}
	}

	// advanced search method
	public void advanced_search(ArrayList<Publication> pubs, ArrayList<Publication> list, String type, String booktitle,
			String isbn, String publisher) {
		for (Publication pub : pubs) {
			if (pub.type.equals(type)) {
				if (booktitle != "") {
					if (isbn != "") {
						if (publisher != "") {
							if (pub.booktitle == null || pub.isbn == null || pub.publisher == null)
								continue;
							if (pub.booktitle.contains(booktitle) && pub.isbn.equals(isbn)
									&& pub.publisher.equals(publisher))
								list.add(pub);
							else
								continue;
						} else {
							if (pub.booktitle == null || pub.isbn == null)
								continue;
							if (pub.booktitle.contains(booktitle) && pub.isbn.equals(isbn))
								list.add(pub);
							else
								continue;
						}
					} else {
						if (publisher != "") {
							if (pub.booktitle == null || pub.publisher == null)
								continue;
							if (pub.booktitle.contains(booktitle) && pub.publisher.equals(publisher))
								list.add(pub);
							else
								continue;
						} else {
							if (pub.booktitle == null)
								continue;
							if (pub.booktitle.contains(booktitle))
								list.add(pub);
							else
								continue;
						}
					}
				} else {
					if (isbn != "") {
						if (publisher != "") {
							if (pub.isbn == null || pub.publisher == null)
								continue;
							if (pub.isbn.equals(isbn) && pub.publisher.equals(publisher))
								list.add(pub);
							else
								continue;
						} else {
							if (pub.isbn == null)
								continue;
							if (pub.isbn.equals(isbn))
								list.add(pub);
							else
								continue;
						}
					} else {
						if (publisher != "") {
							if (pub.publisher == null)
								continue;
							if (pub.publisher.equals(publisher))
								list.add(pub);
							else
								continue;
						} else {
							continue;
						}
					}
				}
			} else
				continue;
		}
	}

}