package com.mini2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class eventlistdao {
	String sql="INSERT INTO event_management.event_list VALUES (?,?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306";
	String username="root";
	String pwrd="mysql";
	public int insert(String eventname ,String desc,String location,String date,String time,String fees)
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,eventname);
			st.setString(2,desc);
			st.setString(3,date);
			st.setString(4,time);
			st.setString(5,location);
			st.setString(6,fees);
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
