package com.team.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team.gs.beans.College;
import com.team.gs.beans.GrievanceSubject;
import com.team.gs.beans.User;
import com.team.gs.util.DBConnection;

public class GrievanceSubjectDao {
	
  public boolean insertGrievanceSubject(GrievanceSubject gs) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into m_grievances_subject values(?,?,?)");
			ps.setInt(1, gs.getId());
			ps.setString(2, gs.getName());
			ps.setInt(3, gs.getCollegeId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public List<GrievanceSubject>  findAll() {
		Connection conn;
		ResultSet rs= null;
		List<GrievanceSubject> listGrievSub=new ArrayList<GrievanceSubject>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_grievances_subject");
			rs= ps.executeQuery();
			
while(rs.next())	
{
	GrievanceSubject c = new GrievanceSubject(rs.getInt(1),rs.getString(2),rs.getInt(3));
	System.out.println(c);
	listGrievSub.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listGrievSub;

	}
	public List<GrievanceSubject>  findAllByCollegeId(int collegeId) {
		Connection conn;
		ResultSet rs= null;
		List<GrievanceSubject> listGrievSub=new ArrayList<GrievanceSubject>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_grievances_subject where college_id="+collegeId);
			rs= ps.executeQuery();
			
while(rs.next())	
{
	GrievanceSubject c = new GrievanceSubject(rs.getInt(1),rs.getString(2),rs.getInt(3));
	System.out.println(c);
	listGrievSub.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listGrievSub;

	}
	
	
	public List<GrievanceSubject>  findById(Integer id) {
		Connection conn;
		ResultSet rs= null;
		List<GrievanceSubject> listGrievSub=new ArrayList<GrievanceSubject>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_grievances_subject where id=?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
while(rs.next())	
{
	GrievanceSubject c = new GrievanceSubject(rs.getInt(1),rs.getString(2),rs.getInt(3));
	System.out.println(c);
	listGrievSub.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listGrievSub;

	}


}
