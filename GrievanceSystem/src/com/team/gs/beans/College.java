package com.team.gs.beans;

public class College {
	private Integer id;
	private String name;
	private String address;
	private String email;
	private Long contactNo;

	public College(Integer id, String name, String address, String email, Long contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", contactNo="
				+ contactNo + "]";
	}

}
