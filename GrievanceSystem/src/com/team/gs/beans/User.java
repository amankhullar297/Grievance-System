package com.team.gs.beans;


public class User {
	String email;
	String userName;
	String password;
	Character role;
	Long lastScreen;
	Integer collegeId;
	Character status;
	
	
	
	public User(String email, String userName, String password, Character role, Long lastScreen, Integer collegeId,
			Character status) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.lastScreen = lastScreen;
		this.collegeId = collegeId;
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Character getRole() {
		return role;
	}
	public void setRole(Character role) {
		this.role = role;
	}
	public Long getLastScreen() {
		return lastScreen;
	}
	public void setLastScreen(Long lastScreen) {
		this.lastScreen = lastScreen;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", lastScreen=" + lastScreen + ", collegeId=" + collegeId + ", status=" + status + "]";
	}
	
	

}
