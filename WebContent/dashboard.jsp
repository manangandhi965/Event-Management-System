<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Dashboard</title>
<style>
.top{
border:2px solid black;
background:#E0E1D5;
	height:10%;
	width:100%;
}
.topa{
float:left;
margin-top:20px;
margin-left:10px;
}
.topb{
float:right;
margin-top:20px;
margin-right:10px;
}
.left{
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
#ims{
height:25px;
width:160px;
}

</style>
<script>
function myfunction()
{
	if(confirm("Cancel Register")==true)
		return true;
	else
		return false;
	}
</script>
</head>
<body>
<%
if(session.getAttribute("uname")==null)
{
	response.sendRedirect("index.html");
}

HttpSession sess = request.getSession();
String uname= (String)session.getAttribute("uname"); 
try {
String username="root";
String pwrd="mysql";
String url="jdbc:mysql://localhost:3306";

Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(url,username,pwrd);
String QueryString = "SELECT a.name,description,date,time,location FROM event_management.registerevent a natural join event_management.event_list b where email=?";
PreparedStatement statement = con.prepareStatement(QueryString);
statement.setString(1,uname);
ResultSet rs = statement.executeQuery();

String s = "SELECT wallet FROM event_management.student_data where email=?";
PreparedStatement statement1 = con.prepareStatement(s);
statement1.setString(1,uname);
ResultSet rs1 = statement1.executeQuery();
%>
<div class="top">
<div class="topa">

<%=uname %></div><div class="topb">
<form action="logout" method="post"><button type="submit">Logout</button></form>
</div>
</div>
<div class="left"><a href="event.jsp"><button id="ims" style="margin-top:30px; margin-left:50px;">Register for new event</button></a>
<br>
<p style="margin-top:20px;margin-left:50px;margin-bottom:30px;">
Wallet:
 <% rs1.next();%>
	 <%=rs1.getString(1) %><p>
	
</div>
<div class="main">
<h1 style="margin-left:20px;">You have registered for the following events</h1>

 
<br>
<%
while (rs.next()) {
%>
 <div class="a">
		Name: <%=rs.getString(1)%><br>
		Description: <%=rs.getString(2) %><br>
		Date: <%=rs.getString(3) %><br>
		Time: <%=rs.getString(4) %><br>
		Location: <%=rs.getString(5) %><br>
		<br>
		<form action="cancelregister" method="post">
		<input type="hidden" value="<%=uname%>" name="uname">
		<input  type="hidden" value="<%=rs.getString(1)%>" name="eventname">
		<button type="submit" onclick="return myfunction()">Cancel Register</button>
		</form>
</div>
<hr>
<% } %>

<%
rs.close();
statement.close();
} catch (Exception ex)  {
	System.out.println(ex);
%>

<%
out.println("Unable to connect to database.");
}
%>
</div>
<br>

</font>
</body>
</html>