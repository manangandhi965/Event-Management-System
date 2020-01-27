<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Event</title>
</head>
<body>
<%
if(session.getAttribute("fname")==null)
{
	response.sendRedirect("index.html");
}
%>
 	<form name="facultyevent" method="post" action="eventlist">
<table  cellspacing=5 align="center">
	<caption><h2>Event form</h2></caption>
<tr>
	<td>Event name:</abbr></td><td> <input name="eventname" placeholder="Enter event name" style="height: 25px; width: 200px;" type="text" size="30" required></td>
</tr>

<td>
Enter event description: </td><td></abbr> <input type="text" name="description" value="" 
 style="height: 25px; width: 200px;" size="20" required="required" title="enter event description">
</td>
</tr>
<tr>

<td>
Enter event Date: </td><td></abbr> <input type="date" name="eventdate" value="" 
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
<td>Enter event fees:</td><td><input type="number" name="fees" required></td>
</tr>
<tr>
	<td>
<input id="login" type="submit" value="Add"></td><td>
	<input id="reset" type="reset" value="Reset"></td><td>
</td></tr>
</table>
</form>
</body>
</html>