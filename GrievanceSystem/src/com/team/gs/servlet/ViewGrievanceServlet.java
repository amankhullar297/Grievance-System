package com.team.gs.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.gs.beans.Grievance;
import com.team.gs.beans.Student;
import com.team.gs.beans.User;
import com.team.gs.dao.GrievanceDao;
import com.team.gs.dao.StudentDao;

@WebServlet("/ViewGrievanceServlet")
public class ViewGrievanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewGrievanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	User loginUser=(User)request.getSession().getAttribute("loginUser");
	if(loginUser!=null){
		if(loginUser.getRole()=='a'){
		GrievanceDao grievanceDao=new GrievanceDao();
		List<Grievance> grievanceList=grievanceDao.findAllWithSubjectAndCollegeId(loginUser.getCollegeId());
		System.out.println("list iside view grievance servlet"+grievanceList);
		request.setAttribute("grievanceList", grievanceList);
		request.setAttribute("loginUser",loginUser);
		RequestDispatcher rd=request.getRequestDispatcher("view_grievance.jsp");
		rd.forward(request, response);
		}
		else if(loginUser.getRole()=='s'){
			System.out.println(loginUser.getRole());
			String email=loginUser.getEmail();
			StudentDao sd=new StudentDao();
			Student s=sd.findByEmail(email);
			GrievanceDao grievanceDao=new GrievanceDao();
			List<Grievance> grievanceList=grievanceDao.findAllWithSubjectAndStudentId(s.getEnrollmentId());
			System.out.println(grievanceList);
			System.out.println("Student list iside view grievance servlet"+grievanceList);
			request.setAttribute("grievanceList", grievanceList);
			request.setAttribute("loginUser",loginUser);
			request.setAttribute("student",s);
			RequestDispatcher rd=request.getRequestDispatcher("view_grievance.jsp");
			rd.forward(request, response);
			}
	}
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
		
	}//Func



}
