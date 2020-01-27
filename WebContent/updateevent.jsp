<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Update</title>
</head>
<body>
	<% 
	if(session.getAttribute("fname")==null)
	{
		response.sendRedirect("index.html");
	}
	HttpSession sese=request.getSession();
	String ename=(String)sese.getAttribute("eventname");
%>
	<br>
	<br>
	<form name="facultyevent" method="post" action="eventupdate">
<table  cellspacing=5 align="center">
	<caption><h2>Event form</h2></caption>
<tr>
	<td>Event name:</abbr></td><td><%=ename %></td>
	<input type="hidden" value="<%=ename %>" name="eventname">
</tr>

<td>
Enter event description: </td><td> <input type="text" name="description" 
 style="height: 25px; width: 200px;" size="20" required="required" title="enter event description">
</td>
</tr>
<tr>

<td>
Enter event Date: </td><td> <input  type="date" name="eventdate" value="" 
style="height: 25px; width: 200px;" size="20" required="required" title="enter event date"></td></tr>
<tr>

<td>
Enter event time: </td><td></abbr> <input type="time" name="eventtime" value="" 
style="height: 25px; width: 200px;" size="20" required="required" title="enter event time" value="00:00:00"></td></tr>
<tr>

<td>
Enter event location: </td><td><input type="text" name="eventlocation" value="" 
 style="height: 25px; width: 200px;" size="20" required="required" title="enter event location"></td></tr>
<tr>
<td>Enter event fees:</td><td><input type="number" name="fees"></td>
</tr>
<tr>
	<td>
<input id="login" type="submit" value="Add"></td><td>
</body>
</html>