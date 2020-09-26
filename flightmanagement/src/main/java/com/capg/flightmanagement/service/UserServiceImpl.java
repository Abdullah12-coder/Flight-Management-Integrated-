package com.capg.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.flightmanagement.dao.UserDao;
import com.capg.flightmanagement.dto.ForgetPasswordDto;
import com.capg.flightmanagement.dto.UserLoginDto;
import com.capg.flightmanagement.exceptions.UserNotFoundException;
import com.capg.flightmanagement.models.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private IUserService service;
	
	@Override
	public String register(User u) {
		List<User> userList = fetchAllUsers();
		String email = u.getEmail();
		Boolean flag = false;
		for (int i = 0; i < userList.size(); i++) {
			if(email.equals(userList.get(i).getEmail())){
				flag = true;
			}
		}
		if(flag==true) {
			return "Email already exists";
		}
		else {
			User user = dao.save(u);
			return "Successgully registered with userId="+user.getUserId();
		}
	}


	@Override
	public String doLogin(UserLoginDto loginDto) {
		List<User> userList = fetchAllUsers();
		String role="";
		
		boolean flag = false;
		String email = loginDto.getEmail();
		String password = loginDto.getUserPassword();

		for (int i = 0; i < userList.size(); i++) {
			if(email.equals(userList.get(i).getEmail()) && password.equals(userList.get(i).getUserPassword())){
				role = userList.get(i).getUserType();
				flag = true;
			}
		}
		
		if(flag == true) {
			return "Logged in as "+role;
		}
		else
			return "Wrong Credentials";
	}
	
	@Override
	public User fetchById(int userId) {
		Optional<User> optional = dao.findById(userId);
			if(optional.isPresent()) {
				User u = optional.get();
				return u;
			}
		throw new UserNotFoundException("user not found for id="+userId);	
	}
	
	@Override
	public List<User> fetchAllUsers() {
		List<User> userList = dao.findAll();
		return userList;
	}

	@Override
	public boolean delete(int userId) {
		User user = fetchById(userId);
		dao.delete(user);
		return true;
	}


	@Override
	public String recover(ForgetPasswordDto forgetDto) {
		List<User> userList = fetchAllUsers();
		boolean flag = false;
		int userId = forgetDto.getUserId();
		String email = forgetDto.getEmail();
		String newPassword = forgetDto.getNewPassword();
		for (int i = 0; i < userList.size(); i++) {
			if((userId == userList.get(i).getUserId()) && (email.equals(userList.get(i).getEmail()))){
				flag=true;
			}
		}
		if(flag==true) {
			User user = fetchById(userId);
			user.setUserPassword(newPassword);
			dao.save(user);
			return "Successfully updated";
		}
		return "Try again with another information!!";
	}

	
}
