package com.capg.flightmanagement.dto;

import java.math.BigInteger;

public class CreateUserRequest {

	private int userId;
	private String userType;
	private String userName;
	private String userPassword;
	private BigInteger userPhone;
	private String email;

	
	
	  public int getUserId() { 
		  return userId; }
	  
	  public void setUserId(int userId) { 
		  this.userId = userId; }
	 

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigInteger getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
