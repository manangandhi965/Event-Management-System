package com.mini2.dao;

import java.sql.*;

public class studentregisterdao {

	String sql="INSERT INTO event_management.student_data VALUES (?,?,?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306";
	String username="root";
	String pwrd="mysql";
	String wallet="0";
	public int insert(String uname ,String pass,String firstname,String lastname,String branch,String gender)
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,firstname);
			st.setString(2,lastname);
			st.setString(3,uname);
			st.setString(4,pass);
			st.setString(5, gender);
			st.setString(6,branch);
			st.setString(7,wallet);
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
