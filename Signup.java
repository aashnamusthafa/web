package com.deloitte.limetray.model;

public class Signup {
	
	private String userId;
	private String userName;
	private String password;
	private String emailId;
	private int phone;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Signup [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emailId=" + emailId
				+ ", phone=" + phone + "]";
	}
	

	
	

}
