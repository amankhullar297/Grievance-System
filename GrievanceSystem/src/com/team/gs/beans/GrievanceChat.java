package com.team.gs.beans;

import java.util.Date;

public class GrievanceChat {
	Integer id;
	Integer grievanceId;
	String file;
	String chat;
	Character role;
	Long date;
	Integer collegeId;
	public GrievanceChat(Integer id, Integer grievanceId, String file, String chat, Character role, Long date,
			Integer collegeId) {
		super();
		this.id = id;
		this.grievanceId = grievanceId;
		this.file = file;
		this.chat = chat;
		this.role = role;
		this.date = date;
		this.collegeId = collegeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGrievanceId() {
		return grievanceId;
	}
	public void setGrievanceId(Integer grievanceId) {
		this.grievanceId = grievanceId;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	public Character getRole() {
		return role;
	}
	public void setRole(Character role) {
		this.role = role;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	@Override
	public String toString() {
		return "GrievanceChat [id=" + id + ", grievanceId=" + grievanceId + ", file=" + file + ", chat=" + chat
				+ ", role=" + role + ", date=" + date + ", collegeId=" + collegeId + "]";
	}
	
	

}
