<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Money</title>
</head>
<body>
	<%
	if(session.getAttribute("fname")==null)
	{
		response.sendRedirect("index.html");
	}
	%>
	
	<div style="margin-top:15%;margin-left:40%">
	<form action="addmoney" method="post">
		Email<br><br><input type="text" name="email" placeholder="enter the email id">
		<br>
		<br><br>
		Money in Rs<br><br><input type="number" name="money">
		<br>
		<br>
		
		<input type="submit" value="AddMoney">
	</form>
	</div>
</body>
</html>