package com.team.gs.servlet;

import java.io.IOException;
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
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudentServlet")

public class RegisterStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enrollmentID = request.getParameter("Enrollment-ID");
		String name = request.getParameter("namesurname");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");
		String parentContactNo = request.getParameter("parentcontactNO");
		String address = request.getParameter("address");
		String collegeID = request.getParameter("college");
		String branchID = request.getParameter("branch");
		String password=request.getParameter("Password");
		
		System.out.println(enrollmentID);
		System.out.println(name);
		System.out.println(email);
		System.out.println(contactNo);
		System.out.println(parentContactNo);
		System.out.println(address);
		System.out.println(collegeID);
		System.out.println(branchID);
		Student s=new Student(Integer.parseInt(enrollmentID), name, email,Long.parseLong(contactNo) , Long.parseLong(parentContactNo), address, "aman.jpj", Integer.parseInt(collegeID),Integer.parseInt(branchID),'u' );
		s.setStatus('u');
		System.out.println(s);

		StudentDao sd=new StudentDao();
		boolean b= sd.insertStudent(s);
		if(b)
		{
			User user=new User(email, email, password, 's', System.currentTimeMillis(), Integer.parseInt(collegeID), 'u');
			UserDao userDao = new  UserDao();
			userDao.insertUser(user);
		}
		// user bean me status getter settr
		//user me same data insert id pass + status u
		//redir=ect tosignin .jsp sucess+veriy by admin
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
