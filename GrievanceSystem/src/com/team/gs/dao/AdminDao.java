package com.team.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team.gs.beans.Admin;
import com.team.gs.beans.GrievanceSubject;
import com.team.gs.util.DBConnection;

public class AdminDao {

	public boolean insertAdmin(Admin a) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?,?,?,?,?)");
			ps.setInt(1, a.getId());
			ps.setString(2, a.getName());
			ps.setString(3, a.getEmail());
			ps.setLong(4, a.getContactNo());
			ps.setInt(5,a.getCollegeId());
			ps.setString(6, a.getProfilePic());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	public List<Admin>  findAll() {
		Connection conn;
		ResultSet rs= null;
		List<Admin> Admin=new ArrayList<Admin>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from admin");
			rs= ps.executeQuery();
			
while(rs.next())	
{
	Admin c = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getInt(5),rs.getString(6));
	System.out.println(c);
	Admin.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return Admin;

	}
	public Admin findById(Integer id) {
		Connection conn;
		ResultSet rs= null;
		//Admin Admin=new Admin>();
		Admin c=null;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from admin where id=?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
			if(rs.next()){

	 c = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getInt(5),rs.getString(6));
	System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}
}
