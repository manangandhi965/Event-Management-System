package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini2.dao.eventregisterdao;

@WebServlet("/cancelregister")
public class cancelregister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String eventname = request.getParameter("eventname");
		
		
		eventregisterdao dao = new eventregisterdao();
		
		int count=dao.cancel(eventname,uname);
		System.out.print(count);
		response.sendRedirect("dashboard.jsp");
	}

}
