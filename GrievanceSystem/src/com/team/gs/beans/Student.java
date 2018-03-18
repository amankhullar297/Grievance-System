package com.team.gs.beans;

public class Student {
	Integer enrollmentId;
	String name;
	String email;
	Long contactNo;
	Long parentContact;
	String address;
	String profilePic;
	Integer collegeId;
	Integer branchId;
	char status;
	
	public Student(Integer enrollmentId, String name, String email, Long contactNo, Long parentContact, String address,
			String profilePic, Integer collegeId, Integer branchId, char status) {
		super();
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.parentContact = parentContact;
		this.address = address;
		this.profilePic = profilePic;
		this.collegeId = collegeId;
		this.branchId = branchId;
		this.status = status;
		
	}
	public Integer getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
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
	public Long getParentContact() {
		return parentContact;
	}
	public void setParentContact(Long parentContact) {
		this.parentContact = parentContact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Student [enrollmentId=" + enrollmentId + ", name=" + name + ", email=" + email + ", contactNo="
				+ contactNo + ", parentContact=" + parentContact + ", address=" + address + ", profilePic=" + profilePic
				+ ", collegeId=" + collegeId + ", branchId=" + branchId + ", status=" + status+"]";
	}
	
	
}
