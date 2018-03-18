package com.team.gs.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.team.gs.beans.Grievance;
import com.team.gs.beans.GrievanceChat;
import com.team.gs.beans.User;
import com.team.gs.dao.GChatDao;


@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String result=null;
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Grievance grievance=(Grievance)request.getAttribute("grievance");
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
   String newFileName =  new StringBuffer(String.valueOf("Gchat_")).append(index).toString();
   result = new StringBuffer(filePath).append(newFileName).append(fileExtention).toString();
   
   
   
   
  //return the new file    
} 
  return new File(result); 
          }
});
		String grievanceId=m.getParameter("grievanceId");
		String description=m.getParameter("description");
		String file=m.getParameter("file");
		System.out.println(grievanceId);
		User loginUser=(User)request.getSession().getAttribute("loginUser");
		GChatDao gcd=new GChatDao();
		GrievanceChat gc=new GrievanceChat(null, Integer.parseInt(grievanceId), file, description, loginUser.getRole(), System.currentTimeMillis(), loginUser.getCollegeId());
		gcd.insertGrievanceChat(gc);
	}

}
