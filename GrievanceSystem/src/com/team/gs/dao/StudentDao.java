package com.team.gs.dao;

import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team.gs.beans.Admin;
import com.team.gs.beans.College;
import com.team.gs.beans.Student;
import com.team.gs.beans.User;
import com.team.gs.util.DBConnection;

public class StudentDao {

	public boolean insertStudent(Student s) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			//conn.setAutoCommit(true);
			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getEnrollmentId()+"");
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setLong(4, s.getContactNo());
			ps.setLong(5, s.getParentContact());
			ps.setString(6, s.getAddress());
			ps.setString(7, s.getProfilePic());
			ps.setInt(8, s.getCollegeId());
			ps.setInt(9, s.getBranchId());
			ps.setString(10, s.getStatus() + "");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public List<Student> findAll() {
		Connection conn;
		ResultSet rs = null;
		List<Student> listStudent = new ArrayList<Student>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from student");
			rs = ps.executeQuery();

			while (rs.next()) {
				Student c = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getString(10).charAt(0));
				System.out.println(c);
				listStudent.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listStudent;

	}

	public Student findById(Integer id) {
		Connection conn;
		ResultSet rs = null;
		Student c=null;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from student where enroll_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				 c = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getString(10).charAt(0));
				System.out.println(c);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}
	public Student findByEmail(String email) {
		Connection conn;
		ResultSet rs = null;
		Student c=null;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from student where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				 c = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getString(10).charAt(0));
				System.out.println(c);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		

		return c;

	}
	public Student deleteByEmail(String email) {
		Connection conn;
		Student c=null;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from student where email=?");
			ps.setString(1, email);
			 ps.executeUpdate();

		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		

		return c;

	}

	
	
	public List<Student> findAll(String status,int college_id) {
		Connection conn;
		ResultSet rs = null;
		List<Student> listStudent = new ArrayList<Student>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from student where status =? AND college_id= ?");
			ps.setString(1, status);
			ps.setInt(2, college_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Student c = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5),
				rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getString(10).charAt(0));
				System.out.println(c);
				listStudent.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listStudent;

	}

	public Student alterStatus(Student student) {
		Connection conn;
		
		//User c = null;
		try {
			conn = DBConnection.getConnection();
			student.setStatus('v');
			PreparedStatement ps = conn.prepareStatement("update student set status=? where email=?");
			ps.setString(1,""+ student.getStatus());
			ps.setString(2, student.getEmail());
			 ps.executeUpdate();

	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return student;

	}


	
/*	public boolean insertStudentUser(Student s,User user) {
		Connection conn;
		int test=0,test1=0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			System.out.println(s);
			System.out.println("shdhdgfh");
			PreparedStatement ps = conn.prepareStatement("insert into student(enroll_id,name,email,contact,parent_contact,address,profile_pic,college_id,branch_id,status) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, s.getEnrollmentId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setLong(4, s.getContactNo());
			ps.setLong(5, s.getParentContact());
			ps.setString(6, s.getAddress());
			ps.setString(7, s.getProfilePic());
			ps.setInt(8, s.getCollegeId());
			ps.setInt(9, s.getBranchId());
			ps.setString(10, s.getStatus() + "");
			test=ps.executeUpdate();
			System.out.println("here"+test);
			if(test!=0)
			{
				PreparedStatement ps1 = conn.prepareStatement("insert into user (email,user_name,password,role,last_seen,college_id,status) values(?,?,?,?,?,?,?)");
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getPassword());
				ps.setString(4, "" + user.getRole());
				ps.setString(5, "" + user.getLastScreen());
				ps.setInt(6, user.getCollegeId());
				ps.setString(7, "u");
				test1=ps.executeUpdate();
				if(test1==0)
				{
					conn.rollback();
				}else
				{
					conn.commit();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}*/
}
