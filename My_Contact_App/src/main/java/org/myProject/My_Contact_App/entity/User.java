package org.myProject.My_Contact_App.entity;

public class User {
	private Integer userID;
	private String user_name;
	private String email_address;
	private String phone_number;
	private String login_mane;
	private String password;
	private Integer role;
	private Integer login_status;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getLogin_mane() {
		return login_mane;
	}
	public void setLogin_mane(String login_mane) {
		this.login_mane = login_mane;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getLogin_status() {
		return login_status;
	}
	public void setLogin_status(Integer login_status) {
		this.login_status = login_status;
	}
}
