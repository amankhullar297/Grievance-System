package com.team.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.gs.beans.Admin;
import com.team.gs.beans.Grievance;
import com.team.gs.beans.GrievanceChat;
import com.team.gs.util.DBConnection;
import com.team.gs.util.DateConversionUtil;

public class GChatDao {
	
	public boolean insertGrievanceChat(GrievanceChat gc) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into gchat (grievance_id,file,chat,role,date,college_id) values(?,?,?,?,?,?)");
			ps.setInt(1, gc.getGrievanceId());
			ps.setString(2, gc.getFile());
			ps.setString(3, gc.getChat());
			ps.setString(4, ""+gc.getRole());
			ps.setString(5, ""+gc.getDate());
			ps.setInt(6, gc.getCollegeId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	
	public List<GrievanceChat>  findAll() {
		Connection conn;
		ResultSet rs= null;
		List<GrievanceChat> gChat=new ArrayList<GrievanceChat>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from gchat");
			rs= ps.executeQuery();
			
while(rs.next())	
{
	GrievanceChat c = new GrievanceChat(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),Long.parseLong(rs.getString(6)),rs.getInt(7));
	System.out.println(c);
	gChat.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return gChat;

	}

	public GrievanceChat  findById(Integer id) {
		Connection conn;
		ResultSet rs= null;
		GrievanceChat c=null;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from gchat where id=?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
if(rs.next())	
{
	 c = new GrievanceChat(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),DateConversionUtil.dateToLong(rs.getString(6)),rs.getInt(7));
	System.out.println(c);
	
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}

	public List<GrievanceChat> findByGrievanceId(Integer grievanceId) {
		Connection conn;
		ResultSet rs= null;
		List<GrievanceChat> gChat=new ArrayList<GrievanceChat>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from gchat where grievance_id="+grievanceId);
			rs= ps.executeQuery();
			
while(rs.next())	
{
	GrievanceChat c = new GrievanceChat(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5).charAt(0),Long.parseLong(rs.getString(6)),rs.getInt(7));
	System.out.println(c);
	gChat.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return gChat;

	}
}
