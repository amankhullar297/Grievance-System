package com.team.gs.beans;


public class Grievance {

	private Integer id;
	private Integer subjectId;
	private String description;
	private String file;
	private Long date;
	private Character status;
	private Integer collegeId;
	private Integer studentId;
	private transient String subjectName;
	
	
	public Grievance(Integer id, Integer subjectId, String description, String file, Long date, Character status,
			Integer collegeId, Integer studentId) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.description = description;
		this.file = file;
		this.date = date;
		this.status = status;
		this.collegeId = collegeId;
		this.studentId = studentId;
	}
	
	
	public Grievance(Integer id, Integer subjectId, String description, String file, Long date, Character status,
			Integer collegeId, Integer studentId, String subjectName) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.description = description;
		this.file = file;
		this.date = date;
		this.status = status;
		this.collegeId = collegeId;
		this.studentId = studentId;
		this.subjectName = subjectName;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "Grievance [id=" + id + ", subjectId=" + subjectId + ", description=" + description + ", file=" + file
				+ ", date=" + date + ", status=" + status + ", collegeId=" + collegeId + ", studentId=" + studentId
				+ ", subjectName=" + subjectName + "]";
	}
	

}
