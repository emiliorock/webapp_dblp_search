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
<title>Shopping Cart</title>
</head>

<body bgcolor="#FAFAFA">
<center>

<jsp:useBean id="shoppingcart" class="CS.Publication" scope="session" />

	<H2>My Shopping Cart</H2>
	
	<%
		ArrayList<String> list = (ArrayList)request.getSession().getAttribute("cart");
		if(list.size() == 0) { 
	%>
		<p>Shopping Cart is Empty!</p>
	<% } else {
	%>
	<table>
	<form action="control" method="get">
	<% for(int i = 0;i < list.size();i++) { 
		String title = list.get(i);
	%>
	<tr>
	<td align="left">
	<input type="checkbox" name="delitems" value="<%=title%>">
	<%=title%>
	</td>
	</tr>
	<% } %>
	</table>
	<p></p>
	<input type="submit" value="Remove from Cart">
	<input type="hidden" name="op" value="del">
	</form>
	<% } %>
	
	<p></p>
	<form action="search.jsp" method="post">  
		<input type="submit" value="Home Page">
	</form>
	<p></p>
	<% if(list.size() != 0) { %>
	<form action="results.jsp" method="post">  
		<input type="submit" value="Result Page">
	</form>
	<% } %>

</center>

<p></p>
<center>Written by Mengxin Huang | Student ID z5013846</center>
</body>
</html>