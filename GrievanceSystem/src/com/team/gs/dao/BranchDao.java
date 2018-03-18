package com.team.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team.gs.beans.Branch;
import com.team.gs.beans.GrievanceSubject;
import com.team.gs.util.DBConnection;

public class BranchDao {
	
	public boolean insertBranch(Branch b) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into m_branch values(?,?,?)");
			ps.setInt(1, b.getId());
			ps.setString(2, b.getName());
			ps.setInt(3, b.getCollegeId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	public List<Branch>  findAll() {
		Connection conn;
		ResultSet rs= null;
		List<Branch> Branch=new ArrayList<Branch>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_branch");
			rs= ps.executeQuery();
			
while(rs.next())	
{
	Branch c = new Branch(rs.getInt(1),rs.getString(2),rs.getInt(3));
	System.out.println(c);
	Branch.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return Branch;

	}

	public List<Branch>  findById(Integer id) {
		Connection conn;
		ResultSet rs= null;
		List<Branch> Branch=new ArrayList<Branch>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_branch where id=?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
while(rs.next())	
{
	Branch c = new Branch(rs.getInt(1),rs.getString(2),rs.getInt(3));
	System.out.println(c);
	Branch.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return Branch;

	}
}
