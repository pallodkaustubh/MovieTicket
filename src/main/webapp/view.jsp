<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- 
<h1 style="color: red;">YOUR SELECTED MOVIE IS  <%=request.getAttribute("movie") %></h1>
<h1 style="color: green;">YOU SELECTED TO BOOK   <%=request.getAttribute("number") %> TICKETS </h1>
<h1 style="color: blue;">YOUR TOTAL BILL AMMOUNT (Including 18% GST )  IS  <%=request.getAttribute("bill") %> RS </h1>
 --%>
 
<%
 
  
 boolean status = (Boolean)request.getAttribute("status");
 PrintWriter pw = response.getWriter();
 if (status == true)
 {
	 
	Object movie  =  request.getAttribute("movie");
	Object number  =  request.getAttribute("number");
	Object bill  =  request.getAttribute("bill");
	 
	
	 pw.print("<h1 style='color:green'>"+" BOOKING SUCCESS " +  "</h1>");
	 
	 pw.print("<h1 style='color:blue'>"+"YOUR SELECTED MOVIE IS " +movie+ "</h1>");
	 
	 pw.print("<h1 style='color:black'>"+"YOU SELECTED TO BOOK  " +number+ " " + "TICKETS"+ "</h1>");
	 
	 pw.print("<h1 style='color:green'>"+"YOUR TOTAL BILL AMMOUNT (Including 18% GST )  IS " +bill+   " RS " + "</h1>");
	  
	
	
 }
 else
 {
	 pw.print("<h1 style='color:red'>"+" HOUSEFULL ..!! ALL TICKETS FOR THIS SHOW ARE SOLD .PLS TRY AFTER SOME TIME  " +  "</h1>");
 }
%>








</body>
</html>