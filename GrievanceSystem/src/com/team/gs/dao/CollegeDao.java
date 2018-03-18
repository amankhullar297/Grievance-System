package com.team.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team.gs.beans.College;

import com.team.gs.util.DBConnection;

public class CollegeDao {

	public boolean  insertCollege(College c) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into m_college values(?,?,?,?,?)");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getEmail());
			ps.setLong(5, c.getContactNo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	public List<College>  findAll() {
		Connection conn;
		ResultSet rs= null;
		List<College> listCollege=new ArrayList<College>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_college");
			rs= ps.executeQuery();
			
while(rs.next())	
{
	College c = new College(rs.getInt("id"),rs.getString("name"),rs.getString(3),rs.getString(4),rs.getLong(5));
	System.out.println(c);
     listCollege.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listCollege;

	}

	public List<College>  findById(Integer id) {
		Connection conn;
		ResultSet rs= null;
		List<College> listCollege=new ArrayList<College>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from m_college where id = ?" );
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
while(rs.next())	
{
	College c = new College(rs.getInt("id"),rs.getString("name"),rs.getString(3),rs.getString(4),rs.getLong(5));
	System.out.println(c);
     listCollege.add(c);
     
}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listCollege;

	}


}
