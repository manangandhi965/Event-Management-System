package com.mini2;


//import com.mini2.dao.studentlogindao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini2.dao.studentlogindao;

//import javax.servlet.*;


@WebServlet("/studentlogin")
public class studentlogin extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("password");
		//System.out.println(uname);
		//System.out.println(pass);
		studentlogindao dao = new studentlogindao();
		
		if(dao.verifypassword(uname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			response.sendRedirect("student login.html");
		}
	}

}



