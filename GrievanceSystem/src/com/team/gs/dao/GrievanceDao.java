package com.team.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.team.gs.beans.College;
import com.team.gs.beans.Grievance;
import com.team.gs.beans.User;
import com.team.gs.util.DBConnection;
import com.team.gs.util.DateConversionUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GrievanceDao {

	public boolean insertGrievance(Grievance g) {
		Connection conn;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into grievance(subject_id,description,file,date,status,college_id,student_id) values(?,?,?,?,?,?,?)");
			ps.setInt(1, g.getSubjectId());
			ps.setString(2, g.getDescription());
			ps.setString(3, g.getFile());
			ps.setString(4, "" + g.getDate());
			ps.setString(5, "" + g.getStatus());
			ps.setInt(6, g.getCollegeId());
			ps.setInt(7, g.getStudentId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public List<Grievance> findAll() {
		Connection conn;
		ResultSet rs = null;
		List<Grievance> listGrievance = new ArrayList<Grievance>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from grievance");
			rs = ps.executeQuery();

			while (rs.next()) {
				Grievance c = new Grievance(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						DateConversionUtil.dateToLong("rs.getLong(5)"), rs.getString(6).charAt(0), rs.getInt(7),
						rs.getInt(8));
				System.out.println(c);
				listGrievance.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listGrievance;

	}

	public List<Grievance> findByCollegeId(int CollegeId) {
		Connection conn;
		ResultSet rs = null;
		List<Grievance> listGrievance = new ArrayList<Grievance>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from grievance where college_id=?");
			ps.setInt(1, CollegeId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Grievance c = new Grievance(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						DateConversionUtil.dateToLong("rs.getLong(5)"), rs.getString(6).charAt(0), rs.getInt(7),
						rs.getInt(8));
				System.out.println(c);
				listGrievance.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listGrievance;

	}

	public Grievance findById(Integer id) {
		Connection conn;
		ResultSet rs = null;
		Grievance c = null;

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from grievance where id="+id);
			//ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				c = new Grievance(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						DateConversionUtil.dateToLong("rs.getLong(5)"), rs.getString(6).charAt(0), rs.getInt(7),
						rs.getInt(8));
				System.out.println(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}

	public List<Grievance> findAllWithSubjectAndCollegeId(Integer collegeId) {
		Connection conn;
		ResultSet rs = null;
		List<Grievance> listGrievance = new ArrayList<Grievance>();
		String query = "SELECT g.id,g.subject_id,g.description,g.file,g.date,g.status,"
				+ "g.college_id,g.student_id,s.name " + "FROM grievances.grievance g " + "join m_grievances_subject s "
				+ "on g.subject_id= s.id " + "where g.college_id=" + collegeId + "" + ";";
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Grievance c = new Grievance(rs.getInt("g.id"), rs.getInt("g.subject_id"), rs.getString("g.description"),
						rs.getString("g.file"), rs.getLong("g.date"), rs.getString("g.status").charAt(0),
						rs.getInt("g.college_id"), rs.getInt("g.student_id"), rs.getString("s.name"));
				listGrievance.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("indie dao  find all eith subjec and college idt"+listGrievance);
		return listGrievance;

	}
	public Grievance findAllWithSubjectAndGrievanceId(Integer grievanceId) {
		Connection conn;
		ResultSet rs = null;
		Grievance c=null;
		//List<Grievance> listGrievance = new ArrayList<Grievance>();
		
		String query = "SELECT g.id,g.subject_id,g.description,g.file,g.date,g.status,"
				+ "g.college_id,g.student_id,s.name " + "FROM grievances.grievance g " + "join m_grievances_subject s "
				+ "on g.subject_id= s.id " + "where g.id=" + grievanceId + "" + ";";
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if(rs.next()) {
				 c = new Grievance(rs.getInt("g.id"), rs.getInt("g.subject_id"), rs.getString("g.description"),
						rs.getString("g.file"), rs.getLong("g.date"), rs.getString("g.status").charAt(0),
						rs.getInt("g.college_id"), rs.getInt("g.student_id"), rs.getString("s.name"));
				// System.out.println(c);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("indie dao  find all eith subjec and college idt"+c);
		return c;

	}
	public List<Grievance> findByStudentId(Integer id) {
		Connection conn;
		ResultSet rs = null;
	List<Grievance> c = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from grievance where student_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
			Grievance grev = new Grievance(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getLong(5), rs.getString(6).charAt(0), rs.getInt(7),
						rs.getInt(8));
				//System.out.println(c);
				c.add(grev);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return c;

	}
	public List<Grievance> findAllWithSubjectAndStudentId(Integer studentId) {
		Connection conn;
		ResultSet rs = null;
		List<Grievance> listGrievance = new ArrayList<Grievance>();
		String query = "SELECT g.id,g.subject_id,g.description,g.file,g.date,g.status,"
				+ "g.college_id,g.student_id,s.name " + "FROM grievances.grievance g " + "join m_grievances_subject s "
				+ "on g.subject_id= s.id " + "where g.student_id=" + studentId + "" + ";";
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Grievance c = new Grievance(rs.getInt("g.id"), rs.getInt("g.subject_id"), rs.getString("g.description"),
						rs.getString("g.file"), rs.getLong("g.date"), rs.getString("g.status").charAt(0),
						rs.getInt("g.college_id"), rs.getInt("g.student_id"), rs.getString("s.name"));
				listGrievance.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("indie dao  find all eith subjec and student idt"+listGrievance);
		return listGrievance;

	}




/*public static void main(String agrs[]){
GrievanceDao gd=new GrievanceDao();
Grievance list=gd.findAllWithSubjectAndGrievanceId(1);
System.out.println(list);
}*/	
}

// SELECT
// g.id,g.subject_id,g.description,g.file,g.date,g.status,g.college_id,g.student_id,s.name
// FROM grievances.grievance g join m_grievances_subject s on g.subject_id= s.id
// where g.subject_id=1;

/*
// SELECT
// g.id,g.subject_id,g.description,g.file,g.date,g.status,g.college_id,g.student_id,s.name
// FROM grievances.grievance g join m_grievances_subject s on g.subject_id= s.id
// where g.college_id=1;

*/