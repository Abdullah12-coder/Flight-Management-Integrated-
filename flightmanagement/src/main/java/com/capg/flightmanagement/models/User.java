package com.capg.flightmanagement.models;

import java.math.BigInteger;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@SequenceGenerator(name="seq", initialValue = 100, allocationSize = 2000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name="user_id",unique = true)
	private int userId;
	
	@Column(name="user_email", unique = true)
	private String email;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_phone")
	private BigInteger userPhone;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String email, String userType, String userName, String userPassword, BigInteger userPhone) {
		super();
		this.userId = userId;
		this.email = email;
		this.userType = userType;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", userType=" + userType + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userPhone=" + userPhone + "]";
	}
	
	
	
}
