package CS;

import java.io.*;
import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import CS.Publication;

public class PublicationSax extends DefaultHandler {

	public Publication pub;
	public ArrayList<Publication> pubs;
	public String tag;

	// All the attributes
	public String type;
	public String author;
	public String editor;
	public String title;
	public String booktitle;
	public String pages;
	public String year;
	public String address;
	public String volume;
	public String journal;
	public String number;
	public String month;
	public String url;
	public String cdrom;
	public String cite;
	public String ee;
	public String publisher;
	public String note;
	public String crossref;
	public String isbn;
	public String series;
	public String school;
	public String chapter;
	
	// Start to parse the xml file
	@Override
	public void startDocument() throws SAXException {
		pubs = new ArrayList<Publication>();
		// System.out.print("StartDocument!");
	}

	// parse one element
	@Override
	public void startElement(String uri, String localName, String qname, Attributes attr) throws SAXException {
		// System.out.print("startElement1!");
		if ("article".equals(qname) || "inproceedings".equals(qname) || "incollection".equals(qname)
				|| "proceedings".equals(qname) || "book".equals(qname) || "phdthesis".equals(qname)
				|| "mastersthesis".equals(qname) || "www".equals(qname)) {
			// System.out.print("startElement2!");
			pub = new Publication();
		}
		tag = qname;
		if("article".equals(qname)) {
			pub.settype("article");
		}
		else if("inproceedings".equals(qname) || "www".equals(qname)) {
			pub.settype("conference");
		}
		else if("incollection".equals(qname) || "book".equals(qname)) {
			pub.settype("collection");
		}
		else if("proceedings".equals(qname)) {
			pub.settype("editorship");
		}
		else if("phdthesis".equals(qname) || "mastersthesis".equals(qname) ) {
			pub.settype("thesis");
		}
	}

	// set the attributes of one element
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// System.out.print("1!");
		if (pub != null) {
			// System.out.print("2!");
			String data = new String(ch, start, length);
			if ("author".equals(tag)) {
				pub.setauthor(data);
			}
			if ("editor".equals(tag)) {
				pub.seteditor(data);
			}
			if ("title".equals(tag)) {
				pub.settitle(data);
			}
			if ("booktitle".equals(tag)) {
				pub.setbooktitle(data);
			}
			if ("pages".equals(tag)) {
				pub.setpages(data);
			}
			if ("year".equals(tag)) {
				pub.setyear(data);
			}
			if ("address".equals(tag)) {
				pub.setaddress(data);
			}
			if ("volume".equals(tag)) {
				pub.setvolume(data);
			}
			if ("journal".equals(tag)) {
				pub.setjournal(data);
			}
			if ("number".equals(tag)) {
				pub.setnumber(data);
			}
			if ("month".equals(tag)) {
				pub.setmonth(data);
			}
			if ("url".equals(tag)) {
				pub.seturl(data);
			}
			if ("ee".equals(tag)) {
				pub.setee(data);
			}
			if ("cdrom".equals(tag)) {
				pub.setcdrom(data);
			}
			if ("cite".equals(tag)) {
				pub.setcite(data);
			}
			if ("publisher".equals(tag)) {
				pub.setpublisher(data);
			}
			if ("note".equals(tag)) {
				pub.setnote(data);
			}
			if ("crossref".equals(tag)) {
				pub.setcrossref(data);
			}
			if ("isbn".equals(tag)) {
				pub.setisbn(data);
			}
			if ("series".equals(tag)) {
				pub.setseries(data);
			}
			if ("school".equals(tag)) {
				pub.setschool(data);
			}
			if ("chapter".equals(tag)) {
				pub.setchapter(data);
			}
		}
	}

	// finish parsing one element
	@Override
	public void endElement(String uri, String localName, String qname) throws SAXException {
		// System.out.print("endElement1!");
		if (pub != null && ("article".equals(qname) || "inproceedings".equals(qname) || "incollection".equals(qname)
				|| "proceedings".equals(qname) || "book".equals(qname) || "phdthesis".equals(qname)
				|| "mastersthesis".equals(qname) || "www".equals(qname))) {
			//System.out.print(pub.gettitle());
			pubs.add(pub);
			pub = null;
			tag = null;
		}
	}

	// finish parsing the document
	@Override
	public void endDocument() throws SAXException {
		// System.out.print("EndDocument!");
		super.endDocument();
	}

	public ArrayList<Publication> getPubs() {
		return pubs;
	}

}