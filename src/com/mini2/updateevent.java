package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/updateevent")
public class updateevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventname=request.getParameter("eventname");
		
		HttpSession ses=request.getSession();
		ses.setAttribute("eventname",eventname);
		response.sendRedirect("updateevent.jsp");
	}

}
