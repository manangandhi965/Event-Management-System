package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini2.dao.eventregisterdao;


/**
 * Servlet implementation class eventregister
 */
@WebServlet("/eventregister")
public class eventregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String eventname = request.getParameter("eventname");
		String fees = request.getParameter("fees");
		
		eventregisterdao dao = new eventregisterdao();
		
		int count=dao.insert(uname,eventname);
		if(count!=0)
		{
			int count1=dao.updatemoney(uname,fees);
		}
		System.out.print(count);
		response.sendRedirect("dashboard.jsp");
		

	}

}
