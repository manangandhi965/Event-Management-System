package com.mini2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini2.dao.addmoneydao;
import com.mini2.dao.studentregisterdao;


@WebServlet("/addmoney")
public class addmoney extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String wallet = request.getParameter("money");
		
		
		addmoneydao dao = new addmoneydao();
		
		dao.add(email,wallet);
		
		response.sendRedirect("eventlist.jsp");
	}

}
