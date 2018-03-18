package com.team.gs.beans;

public class Branch {
	
	Integer id;
	String Name;
	Integer CollegeId;
	
	public Branch(Integer id, String name, Integer collegeId) {
		super();
		this.id = id;
		Name = name;
		CollegeId = collegeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getCollegeId() {
		return CollegeId;
	}

	public void setCollegeId(Integer collegeId) {
		CollegeId = collegeId;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", Name=" + Name + ", CollegeId=" + CollegeId + "]";
	}
	
	

}
