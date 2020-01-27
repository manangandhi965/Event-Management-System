package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini2.dao.facultylogindao;
import com.mini2.dao.studentlogindao;

/**
 * Servlet implementation class facultylogin
 */
@WebServlet("/facultylogin")
public class facultylogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("funame");
		String pass = request.getParameter("fpassword");
		//System.out.println(uname);
		//System.out.println(pass);
		facultylogindao dao = new facultylogindao();
		
		if(dao.check(fname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("fname", fname);
			response.sendRedirect("eventlist.jsp");
		}
		else
		{
			//System.out.print("asasas");
			response.sendRedirect("faculty login.html");
		}
	}

}
