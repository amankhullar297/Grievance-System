package com.team.gs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.gs.beans.Student;
import com.team.gs.beans.User;
import com.team.gs.dao.StudentDao;
import com.team.gs.dao.UserDao;

/**
 * Servlet implementation class VerifyUnverifyServlet
 */
@WebServlet("/VerifyUnverifyServlet")
public class VerifyUnverifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email=request.getParameter("email");
	String status=request.getParameter("status");
	System.out.println(email);
	System.out.println(status);
	if(status!=null){
	
	if(status.equals("u")){
		UserDao userDao=new UserDao();
		User user=userDao.findByEmail(email);
		user=userDao.alterStatus(user);
		StudentDao studentDao=new StudentDao();
		Student student=studentDao.findByEmail(email);
		student=studentDao.alterStatus(student);
		System.out.println("Updated");
	}else if(status.equals("d")){
		UserDao userDao=new UserDao();
		User user=userDao.deleteByEmail("email");
		StudentDao studentDao=new StudentDao();
		studentDao.deleteByEmail(email);
	System.out.println("Deleted");
	}}
	RequestDispatcher rd = request.getRequestDispatcher("VerifyStudentServlet");
	rd.forward(request, response);
	
	}

	

}
