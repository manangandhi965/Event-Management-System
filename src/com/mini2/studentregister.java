package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mini2.dao.studentregisterdao;

@WebServlet("/studentregister")
public class studentregister extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("email");
		String pass = request.getParameter("password");
		String branch = request.getParameter("branch");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String gender = request.getParameter("gender");
		//System.out.println(uname);
		//System.out.println(pass);
		studentregisterdao dao = new studentregisterdao();
		
		int count=dao.insert(uname,pass,firstname,lastname,branch,gender);
		System.out.print(count);
		response.sendRedirect("student login.html");
	}
	

}
