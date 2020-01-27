package com.mini2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class addmoneydao {
	String sql="update event_management.student_data set wallet=wallet+? where email=?";
	String url="jdbc:mysql://localhost:3306";
	String username="root";
	String pwrd="mysql";
	public void add(String email ,String money)
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2,email);
			st.setString(1,money);
			st.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
