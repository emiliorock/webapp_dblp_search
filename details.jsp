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
<title>Details</title>
</head>

<body bgcolor="#FAFAFA">
<center>

	<H2>Details of the Publication</H2>

	<%
		ArrayList<Publication> list = (ArrayList)request.getSession().getAttribute("details");
		String title = request.getParameter("title");
	%>
	<% if(list == null)  { %>
	<p>There are no items!</p>
	<% }
       else { %>
       <table>
			<%
				for(Publication item : list) {
					if(item.title.equals(title)) { %>
						<% if(item.title != null) { %>
						<tr>
       					<td align="left">
							Title: <%=item.title%>
						</td>
						</tr>
						<% } %>
						<% if(item.author != null) { %>
						<tr>
       					<td align="left">
							Author: <%=item.author%>
						</td>
						</tr>
						<% } %>
						<% if(item.year != null)  { %>
						<tr>
       					<td align="left">
							Year: <%=item.year%>
						</td>
						</tr>
						<% } %>
						<% if(item.journal != null)  { %>
						<tr>
       					<td align="left">
							Journal: <%=item.journal%>
						</td>
						</tr>
						<% } %>
						<% if(item.publisher != null) { %>
						<tr>
       					<td align="left">
							Publisher: <%=item.publisher%>
						</td>
						</tr>
						<% } %>
						<% if(item.isbn != null)  { %>
						<tr>
       					<td align="left">
							ISBN: <%=item.isbn%>
						</td>
						</tr>
						<% } %>
						<% if(item.pages != null)  { %>
						<tr>
       					<td align="left">
							Pages: <%=item.pages%>
						</td>
						</tr>
						<% } %>
						<% if(item.type != null) { %>
						<tr>
       					<td align="left">
							Type: <%=item.type%>
						</td>
						</tr>
						<% } %>
						<% if(item.booktitle != null) { %>
						<tr>
       					<td align="left">
							Book Title: <%=item.booktitle%>
						</td>
						</tr>
						<% } %>
						<% if(item.ee != null)  { %>
						<tr>
       					<td align="left">
							EE: <%=item.ee%>
						</td>
						</tr>
						<% } %>
				<% }
				}
			%>
	<% } %>

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

<p></p>
<center>Written by Mengxin Huang | Student ID z5013846</center>
</body>
</html>