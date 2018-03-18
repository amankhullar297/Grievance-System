package com.team.gs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.gs.beans.Student;
import com.team.gs.beans.User;
import com.team.gs.dao.StudentDao;

/**
 * Servlet implementation class VerifyStudentServlet
 */
@WebServlet("/VerifyStudentServlet")
public class VerifyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    StudentDao sd=new StudentDao();
    HttpSession session=request.getSession();
    User u= (User) session.getAttribute("loginUser");
    if(u==null){
    	RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
        rd.forward(request, response);
    }
    int collegeId=u.getCollegeId();
    List<Student> studentList=sd.findAll("u",collegeId);
    request.setAttribute("studentList", studentList);
    RequestDispatcher rd=request.getRequestDispatcher("verifyStudent.jsp");
    rd.forward(request, response);
	}

	

}
