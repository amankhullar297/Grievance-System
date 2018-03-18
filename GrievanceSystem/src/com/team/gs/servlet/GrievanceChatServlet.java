package com.team.gs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.gs.beans.Grievance;
import com.team.gs.beans.GrievanceChat;
import com.team.gs.beans.User;
import com.team.gs.dao.GChatDao;
import com.team.gs.dao.GrievanceDao;


@WebServlet("/GrievanceChatServlet")
public class GrievanceChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//HttpSession session=request.getSession();
	    //User u= (User) session.getAttribute("loginUser");
		String id=(String)request.getParameter("grievanceId");
		System.out.println(id);
		if(id!=null){
		GrievanceDao gd=new GrievanceDao();
	   Grievance grievance=gd.findAllWithSubjectAndGrievanceId(Integer.parseInt(id));
	   GChatDao gChat=new GChatDao();
	   List<GrievanceChat> list=gChat.findByGrievanceId(Integer.parseInt(id));
	   System.out.println(grievance);
	   System.out.println(list);
	   request.setAttribute("grievance", grievance);
	   request.setAttribute("list", gChat);
		RequestDispatcher rd=request.getRequestDispatcher("chat_page.jsp");
		rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
