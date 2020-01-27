<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Page</title>
<style>
.top{
border:2px solid black;
background:#E0E1D5;
padding:30px;
	height:10%;
	width:100%;
}
.topa{
float:left;
margin-top:-10px;
}
.topb{
float:right;
margin-top:-10px;
margin-right:70px;
}
.left{
clear: both;
float:left;
height:15%;
width:20%;
background:#E7DDA5;
background-repeat:repeat-y;
}
.main{
background:#FBEEA0;
background-attachment:fixed;	
height:auto;
width:80%;
float:right;
}
	.a{
margin-left: 20px;
background:#FBEEA0;
}
</style>
</head>
<body>
	<%
	if(session.getAttribute("fname")==null)
	{
		response.sendRedirect("index.html");
	}
	%>
	
	<%
	
//HttpSession sess = request.getSession();
String fname= (String)session.getAttribute("fname"); 
try {
String username="root";
String pwrd="mysql";
String url="jdbc:mysql://localhost:3306";

Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(url,username,pwrd);
String QueryString = "SELECT * FROM event_management.event_list";
PreparedStatement statement = con.prepareStatement(QueryString);
ResultSet rs = statement.executeQuery();

%>
<div class="top">
<div class="topa">
<%=fname %>
</div>
<div class="topb">
<form action="logout" method="post"><button type="submit">Logout</button></form>
</div>
 </div>
 <div class="left"><button type="submit" style="margin-left:40px;margin-top:20px;" onclick="window.location.href='facultyevent.jsp' ">Add Event</button>
 <br>
 <br>
 
 <button style="margin-left:40px;margin-bottom:20px;" onclick="window.location.href='addmoney.jsp'">Add Money To Wallet</button>
 </div>
<div class="main">
<h1 style="margin-left:10px;">There are following events</h1>
<%
while (rs.next()) {
%>
 <div class="a">
		Name: <%=rs.getString(1)%><br>
		Description: <%=rs.getString(2) %><br>
		Date: <%=rs.getString(3) %><br>
		Time: <%=rs.getString(4) %><br>
		Location: <%=rs.getString(5) %><br>
		Fees:<%=rs.getString(6) %><br>
		<form action="updateevent" method="post">
		<input  type="hidden" value="<%=rs.getString(1)%>" name="eventname">
		<button type="submit">Update Event</button>
		</form>
		<form action="deleteevent" method="post">
		<input  type="hidden" value="<%=rs.getString(1)%>" name="eventname">
		<input  type="hidden" value="<%=rs.getString(6)%>" name="fees">
		<button type="submit">Delete Event</button>
		</form>
</div>
<hr>
<% } %>

<%
rs.close();
statement.close();
} catch (Exception ex)  {

//out.println("Unable to connect to database.");
System.out.println(ex);
}
%>
</div>
</body>
</html>