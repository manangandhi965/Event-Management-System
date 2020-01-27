package com.mini2.dao;

import java.sql.*;

public class facultylogindao {

	String sql="SELECT * FROM event_management.faculty_data WHERE email=? AND password=?";
	String url="jdbc:mysql://localhost:3306";
	String username="root";
	String pwrd="mysql";
	public boolean check(String fname ,String pass)
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pwrd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,fname);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				//System.out.print(rs.getString(1));
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
