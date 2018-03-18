package com.team.gs.servlet;

//import java.awt.List;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.gs.beans.Grievance;
import com.team.gs.beans.GrievanceChat;
import com.team.gs.dao.GChatDao;
import com.team.gs.dao.GrievanceDao;


@WebServlet("/StudentChatServlet")
public class StudentChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String studentId=(String)request.getAttribute("studentId");
		String grievanceId=(String)request.getAttribute("grievanceId");
		System.out.println(grievanceId);
		GrievanceDao gd=new GrievanceDao();
		Grievance g=gd.findById(Integer.parseInt(grievanceId));
		request.setAttribute("grievance", g);
		GChatDao gcd=new GChatDao();
	List<GrievanceChat> list=gcd.findByGrievanceId(Integer.parseInt(grievanceId));
	request.setAttribute("list", list);
	RequestDispatcher rd=request.getRequestDispatcher("chat_student.jsp");
	rd.forward(request, response);
	}
}
