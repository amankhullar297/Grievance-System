package com.team.gs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.gs.dao.BranchDao;
import com.team.gs.dao.CollegeDao;


@WebServlet("/LoadRegistrationServlet")
public class LoadRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		CollegeDao cd = new CollegeDao();
		BranchDao bd = new BranchDao();
		request.setAttribute("collegeList",cd.findAll() );
		request.setAttribute("branchList", bd.findAll());
		System.out.println(cd.findAll());
		System.out.println(bd.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.forward(request, response);
	}
}
