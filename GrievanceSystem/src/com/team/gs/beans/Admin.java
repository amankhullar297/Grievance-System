package com.team.gs.beans;
public class Admin {
	Integer id;
	String name;
	String email;
	Long contactNo;
	Integer collegeId;
	String profilePic;
	public Admin(Integer id, String name, String email, Long contactNo, Integer collegeId, String profilePic) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.collegeId = collegeId;
		this.profilePic = profilePic;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", collegeId="
				+ collegeId + ", profilePic=" + profilePic + "]";
	}
	

}
