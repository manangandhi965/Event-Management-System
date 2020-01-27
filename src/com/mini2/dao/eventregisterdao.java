package com.mini2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class eventregisterdao {
	
	String url="jdbc:mysql://localhost:3306";
	String username="root";
	String pwrd="mysql";
	public int insert(String uname ,String eventname)
	{
		String sql="INSERT INTO event_management.registerevent VALUES (?,?)";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,eventname);
			int count = st.executeUpdate();
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	public int delete(String eventname)
	{
		String sql="DELETE FROM event_management.event_list where name=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setString(1,eventname);
			int count = st.executeUpdate();
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int update(String eventname ,String desc,String location,String date,String time,String fees)
	{
		String sql="UPDATE event_management.event_list SET description=?,date=?,time=?,location=?,fees=? where name=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,desc);
			st.setString(2,date);
			st.setString(3,time);
			st.setString(4,location);
			st.setString(5,fees);
			st.setString(6,eventname);
			
			int count = st.executeUpdate();
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int cancel(String eventname,String uname)
	{
		String sql="DELETE FROM event_management.registerevent where name=? and email=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2, uname);
			st.setString(1,eventname);
			int count = st.executeUpdate();
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int updatemoney(String uname,String fees)
	{
		String sql="update event_management.student_data set wallet=wallet-? where email=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2,uname);
			st.setString(1,fees);
			int count = st.executeUpdate();
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	public int givemoney(String eventname,String fees)
	{
		String sql1="select email from event_management.registerevent where name=?";
		//String sql="update event_management.student_data set wallet=wallet+? where email=?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql1);
			st.setString(1,eventname);
			ResultSet rs=st.executeQuery();
			int count=5 ;
			while(rs.next())
			{
				String email=rs.getString(1);
				System.out.println(email);
				add(email,fees);
			}
			
			return count;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public void add(String email ,String money)
	{
		
		try{
			String sql="update event_management.student_data set wallet=wallet+? where email=?";
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
