package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini2.dao.eventlistdao;



@WebServlet("/eventlist")
public class eventlist extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventname = request.getParameter("eventname");
		String desc= request.getParameter("description");
		String location = request.getParameter("eventlocation");
		String date = request.getParameter("eventdate");
		String time = request.getParameter("eventtime");
		String fees = request.getParameter("fees");
		//System.out.println(uname);
		//System.out.println(pass);
		eventlistdao dao = new eventlistdao();
		
		int count=dao.insert(eventname,desc,location,date,time,fees);
		System.out.print(count);
		
		response.sendRedirect("eventlist.jsp");
	}

}
