package com.mini2.dao;

import java.sql.*;

public class facultyregisterdao {

	String sql="INSERT INTO event_management.faculty_data VALUES (?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306";
	String username="root";
	String pwrd="mysql";
	public int insert(String uname ,String pass,String firstname,String lastname,String department)
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,firstname);
			st.setString(2,lastname);
			st.setString(3,uname);
			st.setString(4,pass);
			st.setString(5,department);
			int count = st.executeUpdate();
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
}
