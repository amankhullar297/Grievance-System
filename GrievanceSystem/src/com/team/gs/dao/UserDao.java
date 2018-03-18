package com.team.gs.dao;

import com.team.gs.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.gs.beans.College;
import com.team.gs.beans.GrievanceChat;
import com.team.gs.beans.Student;
import com.team.gs.beans.User;
import com.team.gs.util.DBConnection;
import com.team.gs.util.DateConversionUtil;

public class UserDao {

	public boolean insertUser(User u) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into user (email,user_name,password,role,last_seen,college_id,status) values(?,?,?,?,?,?,?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());
			ps.setString(4, "" + u.getRole());
			ps.setString(5, "" + u.getLastScreen());
			ps.setInt(6, u.getCollegeId());
			ps.setString(7, "u");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	public User  validateUser(String username,String password) {
		Connection conn;
		ResultSet rs= null;
		User c=null;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where email=? and  password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs= ps.executeQuery();
			
if(rs.next())	
{
	 c = new User(rs.getString(1),rs.getString(2),rs.getString(3),(rs.getString(4)).charAt(0),rs.getLong(5),rs.getInt(6),rs.getString(7).charAt(0));
	 System.out.println(c);
	
     
}
else
{
	return null;
	}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}

	public List<User> findAll() {
		Connection conn;
		ResultSet rs = null;
		List<User> listUser = new ArrayList<User>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user");
			rs = ps.executeQuery();

			while (rs.next()) {
				User c = new User(rs.getString(1), rs.getString(2), rs.getString(3), (rs.getString(4)).charAt(0),
						DateConversionUtil.dateToLong("rs.getLong(5)"), rs.getInt(6),rs.getString(7).charAt(0));
				System.out.println(c);
				listUser.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listUser;

	}

	public User findByEmail(String mail) {
		Connection conn;
		ResultSet rs = null;
		User c = null;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where email=?");
			ps.setString(1, mail);
			rs = ps.executeQuery();

			if (rs.next()) {
				c = new User(rs.getString(1), rs.getString(2), rs.getString(3), (rs.getString(4)).charAt(0),
						rs.getLong(5), rs.getInt(6),rs.getString(7).charAt(0));
				System.out.println(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}

	public User deleteByEmail(String mail) {
		Connection conn;
		
		User c = null;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from user where email=?");
			ps.setString(1, mail);
			 ps.executeUpdate();

	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}

	public User alterStatus(User user) {
		Connection conn;
		
		//User c = null;
		try {
			conn = DBConnection.getConnection();
			user.setStatus('v');
			PreparedStatement ps = conn.prepareStatement("update user set status=? where email=?");
			ps.setString(1,""+ user.getStatus());
			ps.setString(2, user.getEmail());
			 ps.executeUpdate();

	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return user;

	}

}
