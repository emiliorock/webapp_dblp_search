<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="CS.Publication"%>
<%@page import="CS.PublicationSax"%>
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.ServletException"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body bgcolor="#FAFAFA">
<center>

	<H2>Search Result</H2>

	<%
		ArrayList<Publication> list = (ArrayList)request.getSession().getAttribute("results");
		int pageNo = 1;
		int pageSize = 10;
		int total = list.size();
		int totalPage = total/pageSize+((total%pageSize)>0?1:0);
		String str = (String)request.getParameter("No");
		System.out.println(str);
		if(str != null) {
			pageNo = Integer.valueOf(str);
			System.out.println(pageNo);
		}
	%>
	
	<% if(list.size() == 0)  { %>
			<p>Sorry, no matching datasets found!</p>
	<% } else { %>
	
	<table>
	<form action="control" method="get">
	<% 	int end = Math.min(list.size(), (pageNo * 10 - 1));
		if(pageNo == totalPage)
			end = list.size() - 1;
		for(int i = (pageNo - 1) * 10;i <= end;i++) { 
			String title = list.get(i).title;
	%>
	<tr>
	<td align="left">
		<input type="checkbox" name="additems" value="<%=title%>">
		<a href='<%=request.getContextPath()%>/details.jsp?title=<%=title%>'><%=title%></a>
	</td>
	</tr>
	<% } %>
	</table>
	<p></p>
	<table>
	<tr>
	<td align="left">
	<input type="submit" value="Add to cart"> 
	<input type="hidden" name="op" value="add">
	</td>
	</tr>
	</table>
	</form>
	
	<% } %>
	
	<%
		if(pageNo != 1 && list.size() != 0) { %>
		<a href='<%=request.getContextPath()%>/results.jsp?No=<%=pageNo - 1%>'>Previous Page</a>	
	<%
		
		}
	%>
	
	<%
		if(pageNo != totalPage && list.size() != 0) { %>
		<a href='<%=request.getContextPath()%>/results.jsp?No=<%=pageNo + 1%>'>Next Page</a>			
	<% 
		
		} 
	%>
	
	<% request.getSession().setAttribute("details", list); %>
	
<table>
	<tr>
	<td align="left">
		<form action="search.jsp" method="post">
		Home Page
	</td>
	<td align="left">
		<input type="submit" value="Go"/>
	</td>
		</form>
	</tr>
	<p></p>
	<tr>
	<td align="left">
		<form action="shoppingcart.jsp" method="post">
		Shopping Cart
	</td>
	<td align="left">
		<input type="submit" value="Go"/>
	</td>
		</form>
	</tr>
</table>

</center>

<p></p>
<center>Written by Mengxin Huang | Student ID z5013846</center>
</body>
</html>