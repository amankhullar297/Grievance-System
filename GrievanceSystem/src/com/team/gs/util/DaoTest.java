package com.team.gs.util;

import com.team.gs.beans.Admin;
import com.team.gs.beans.Branch;
import com.team.gs.beans.College;
import com.team.gs.beans.Grievance;
import com.team.gs.beans.GrievanceChat;
import com.team.gs.beans.GrievanceSubject;
import com.team.gs.beans.Student;
import com.team.gs.beans.User;
import com.team.gs.dao.AdminDao;
import com.team.gs.dao.BranchDao;
import com.team.gs.dao.CollegeDao;
import com.team.gs.dao.GChatDao;
import com.team.gs.dao.GrievanceDao;
import com.team.gs.dao.GrievanceSubjectDao;
import com.team.gs.dao.StudentDao;
import com.team.gs.dao.UserDao;
import com.team.gs.util.*;

public class DaoTest {

	public static void main(String[] args) {
		
		StudentDao sd = new StudentDao();
		sd.findAll();
		//User a=new User("aman.khullar5@gmail.com","aman","aman",'a',DateConversionUtil.dateToLong("06/07/1996"),3);
		///UserDao sd=new UserDao();
		//sd.insertUser(a);
		//sd.findAll();
		//sd.findByEmail("aman.khullar297@gmail.com");
		//Grievance g=new Grievance(102, 1, "Aman", "aman", DateConversionUtil.dateToLong("06/07/1996"), 'a', 3, 102);
		//GrievanceDao gd=new GrievanceDao();
		/*System.out.println(DateConversionUtil.dateToLong("06/07/1997"));
		long l =DateConversionUtil.dateToLong("06/07/1997");
		System.out.println(l);
		GrievanceChat gc=new GrievanceChat(111, 122, "aman", "ved", 'a', DateConversionUtil.dateToLong("06/07/1997"), 3);
		GChatDao gd=new GChatDao();
		long a=gc.getDate();*/
		//DateConversionUtil
		/*(Socket) ->
		   inet:setopts(Socket, [{active, once}]), 
		   receive 
		      {udp, Socket, Host, Port, Bin} -> 
		      io:format("server received:~p~n",[Bin]), 
		      gen_udp:send(Socket, Host, Port, Bin), 
		      loop(Socket) 
		   end. 

		client(N) -> 
		   {ok, Socket} = gen_udp:open(0, [binary]), 
		   io:format("client opened socket=~p~n",[Socket]), 
		   ok = gen_udp:send(Socket, "172.168.31.210", 4000, N), Value = receive 
		      {udp, Socket, _, _, Bin} ->
		         io:format("client received:~p~n",[Bin]) after 2000 ->
		      0 */
		
		//System.out.println(gd.insertGrievanceChat(gc));
		//DateConversionUtil.longTodate(gc.getDate());
	//gd.findAll();
	}
	

}
