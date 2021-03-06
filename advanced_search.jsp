<%@page import="CS.Publication"%>
<%@page import="CS.PublicationSax"%>
<%@page import="javax.xml.parsers.SAXParser"%>
<%@page import="javax.xml.parsers.SAXParserFactory"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advanced Search</title>
</head>
<body bgcolor="#FAFAFA">

<jsp:useBean id="advanced_search" class="CS.PublicationSax" scope="session" />

<%
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser parser = factory.newSAXParser();
	File f = new File("F:\\sampledblp.xml"); 
	PublicationSax publications = new PublicationSax(); 
	parser.parse(f, publications);
	ArrayList<Publication> pubs = publications.getPubs();
%>

<%
	Random random = new Random();
	int[] ranpub = new int [15];
	for(int i = 0;i < 15;i++) {
		ranpub[i] = random.nextInt(pubs.size());
		for(int j = 0;j < i;j++) {
			if(ranpub[i] == ranpub[j]) {
				i--;
				break;
			}
		}
	}
%>

<center>

<H2>Advanced Search</H2>

<form action="control" method="post">
	Type of Publication:
	<select name = "type">  
 	 	<option value ="article">Journal</option>  
  		<option value ="conference">Conference</option>  
  		<option value="collection">Collection</option>  
  		<option value="editorship">Editorship</option>  
  		<option value="thesis">Thesis</option>
	</select>  
	<p></p>
	<table>
	<tr>	
  	<td align="left">Title: </td><td align="left"><input type="text" name="title"/></td>
  	</tr>
  	<tr>
  	<td align="left">Author: </td><td align="left"><input type="text" name="author"/></td>
  	</tr>
  	<tr>
  	<td align="left">Year: </td><td align="left"><input type="text" name="year"/></td>
  	</tr>
  	<tr>
  	<td align="left">Book Title: </td><td align="left"><input type="text" name="booktitle"/></td>
  	</tr>
  	<tr>
  	<td align="left">Publisher: </td><td align="left"><input type="text" name="publisher"/></td>
  	</tr>
  	<tr>
  	<td align="left">ISBN: </td><td align="left"><input type="text" name="isbn"/></td>
  	</tr>
	</table>
	
	<p></p>
  	<input type="hidden" name="action" value="advanced"/>
  	<input type="submit" value="Search" />
  	<p></p>
</form>

<p></p>

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

<ul>
<% 	int count = 0;
	for(int i = 0;i < 15;i++) {
		if(pubs.get(ranpub[i]).title != "" && count < 10) {
			count++; %>
			<li><%=pubs.get(ranpub[i]).gettitle()%></li>
		<% }
		else
			continue;
	}%>
</ul>

<p></p>
<center>Written by Mengxin Huang | Student ID z5013846</center>
</body>
</html>