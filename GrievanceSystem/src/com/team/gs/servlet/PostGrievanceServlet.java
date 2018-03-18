package com.team.gs.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.team.gs.beans.Grievance;
import com.team.gs.beans.SessionBean;
import com.team.gs.dao.GrievanceDao;

@WebServlet("/PostGrievanceServlet")
public class PostGrievanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//String result1;
	String result=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest m=new MultipartRequest(request,"f:/aman",2048*2048*5,new com.oreilly.servlet.multipart.DefaultFileRenamePolicy()
	      {
			
            @Override
         public File rename(File f) {
  //Get the directory where the new file will be saved to
  String filePath = f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf("\\") + 1);
 //Get the original file extension
 String fileExtention =   f.getName().substring(f.getName().lastIndexOf('.'));

 for (int index = 0; index < 7; index ++) // displays frequency
  {
     String newFileName =  new StringBuffer(String.valueOf("Pic_")).append(index).toString();
     result = new StringBuffer(filePath).append(newFileName).append(fileExtention).toString();
    //return the new file    
  } 
    return new File(result); 
            }
});
		String subject=m.getParameter("subject");
		String description=(String)m.getParameter("description");
		SessionBean sessionBean=(SessionBean)request.getSession().getAttribute("sessionBean");
		if(sessionBean!=null)
		{
		System.out.println(subject);
		System.out.println(result);
		Grievance grievance=new Grievance(1, Integer.parseInt(subject), description, result,System.currentTimeMillis(), 'p', sessionBean.getUser().getCollegeId(),sessionBean.getStudent().getEnrollmentId());
		System.out.println(grievance);
		GrievanceDao grievanceDao=new GrievanceDao();
		
		grievanceDao.insertGrievance(grievance);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
	}}