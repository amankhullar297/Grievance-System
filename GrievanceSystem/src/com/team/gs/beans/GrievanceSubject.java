package com.team.gs.beans;

public class GrievanceSubject {
	Integer id;
	String name;
	Integer collegeId;
	public GrievanceSubject(Integer id, String name, Integer collegeId) {
		super();
		this.id = id;
		this.name = name;
		this.collegeId = collegeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	@Override
	public String toString() {
		return "GrievanceSubject [id=" + id + ", name=" + name + ", collegeId=" + collegeId + "]";
	}
	

}
