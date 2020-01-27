<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event page</title>
<style>
	.a{
margin-left: 500px;
}
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
.main{
background:#F5EBB0;
}
</style>

</head>
<body>
<%
if(session.getAttribute("uname")==null)
{
	response.sendRedirect("index.html");
}

HttpSession sess = request.getSession();
String uname= (String)sess.getAttribute("uname"); 
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

<%=uname %>
</div>
<div class="topb">
<form action="logout" method="post"><button type="submit">Logout</button></form>
</div>
</div>
<div class="main">
<h1 style="margin-left:500px;"> The events are</h1>
<%
String Query="select * from event_management.student_data where email=?";
PreparedStatement s = con.prepareStatement(Query);
s.setString(1,uname);
ResultSet rs1 = s.executeQuery();
rs1.next();
String fees[]=new String[10];
int i=0;
while (rs.next()) {
%>
 <div class="a">
	  	Name: <%=rs.getString(1)%><br>
		Description: <%=rs.getString(2) %><br>
		Date: <%=rs.getString(3) %><br>
		Time: <%=rs.getString(4) %><br>
		Location: <%=rs.getString(5) %><br>
		Fees: <%=rs.getString(6) %><br> <br>
		<%
		fees[i]=rs.getString(6);
		String event=rs.getString(1);
		String Qu="select * from event_management.registerevent where email=? and name=?";
		PreparedStatement sta = con.prepareStatement(Qu);
		sta.setString(1,uname);
		sta.setString(2,event);
		ResultSet rs2 = sta.executeQuery();

		%> 
		<form action="eventregister" method="post" name="register">
		<input type="hidden" value="<%=uname%>" name="uname">
	  	 <input  type="hidden" value="<%=rs.getString(1)%>" name="eventname">
		<input type="hidden" value="<%=rs.getString(6) %>" name="fees">
		<input type="hidden" value="<%=rs1.getString(7) %>" name="wallet">
		
		<input type="submit" onclick="return checkmoney(<%=rs.getString(6) %>)" value="Register">
		</form>
		
		
</div>
<hr>
<% 


} %>
<script>
	function checkmoney(fees)
	{
		var wallet = parseInt(document.forms["register"]["wallet"].value);
		console.log(fees);
		console.log(wallet);
		if(fees>wallet)
			{
				alert("you do not have enough money in wallet");
				return false;
			}
		//if(confirm("")==false)
			return confirm("Confirm register");
		
	}
	
</script>
<%


} catch (Exception ex)  {
	System.out.println(ex);
	System.out.print("Error in event page");
%>
<font size="+3" color="red">
<%
out.println("Unable to connect to database.");
}
%>
</div>
</font>
</body>
</html>