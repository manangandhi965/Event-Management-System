package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini2.dao.facultylogindao;
import com.mini2.dao.facultyregisterdao;

/**
 * Servlet implementation class facultyregister
 */
@WebServlet("/facultyregister")
public class facultyregister extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("femail");
		String pass = request.getParameter("fpassword");
		String department = request.getParameter("department");
		String lastname = request.getParameter("flastname");
		String firstname = request.getParameter("ffirstname");
		//System.out.println(uname);
		//System.out.println(pass);
		facultyregisterdao dao = new facultyregisterdao();
		
		int count=dao.insert(uname,pass,firstname,lastname,department);
		System.out.print(count);
		
		response.sendRedirect("faculty login.html");
	}

}
