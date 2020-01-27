package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini2.dao.eventregisterdao;


@WebServlet("/deleteevent")
public class deleteevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventname = request.getParameter("eventname");
		String fees=request.getParameter("fees");
		
		eventregisterdao dao = new eventregisterdao();
		
		int count=dao.delete(eventname);
		System.out.print(count);
		int count1=dao.givemoney(eventname,fees);
		System.out.print(count1);
		response.sendRedirect("eventlist.jsp");
	}

}
