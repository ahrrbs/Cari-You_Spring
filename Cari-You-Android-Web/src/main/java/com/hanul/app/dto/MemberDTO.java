package com.hanul.app.dto;

public class MemberDTO {
	String member_id, password, name, phone, email;

	
	public MemberDTO(String member_id, String name, String phone, String email) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}



	public MemberDTO(String member_id, String password, String name, String phone, String email) {
		super();
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}



	public String getMember_id() {
		return member_id;
	}



	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	
	
	

}
