package com.team.gs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.team.gs.beans.SessionBean;
import com.team.gs.beans.User;
import com.team.gs.dao.StudentDao;
import com.team.gs.dao.UserDao;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		UserDao ud = new UserDao();
		
	User loginUser=ud.validateUser(username, password);
	if(loginUser!=null)
	{

		
		if(loginUser.getRole()=='a'){
			HttpSession session=request.getSession();
			session.setAttribute("email", loginUser.getEmail());
			session.setAttribute("loginUser", loginUser);
		  RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		  rd.forward(request, response);
		}else if(loginUser.getRole()=='s')
		{	
			if(loginUser.getStatus()=='v')
			{
				HttpSession session=request.getSession();
				session.setAttribute("loginUser", loginUser);
				SessionBean sessionBean = new SessionBean();
				sessionBean.setUser(loginUser);
				sessionBean.setStudent(new StudentDao().findByEmail(loginUser.getEmail()));
				session.setAttribute("sessionBean",sessionBean);
			RequestDispatcher rd = request.getRequestDispatcher("StudentDashboard.jsp");
			rd.forward(request, response);
			}else
			{
				request.setAttribute("message", "You Are Not Verified BY Admin");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		//session
	
	}
	else
	{
		request.setAttribute("message", "Invalid username and password");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	}

}
