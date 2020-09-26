package com.capg.flightmanagement.service;

import java.util.List;

import com.capg.flightmanagement.dto.ForgetPasswordDto;
import com.capg.flightmanagement.dto.UserLoginDto;
import com.capg.flightmanagement.models.User;

public interface IUserService {

	String register(User u);
	
	User fetchById(int userId);
	
	boolean delete(int userId);
	
	List<User> fetchAllUsers();
	
	String doLogin(UserLoginDto loginDto);
	
	String recover(ForgetPasswordDto forgetDto);
	
}
