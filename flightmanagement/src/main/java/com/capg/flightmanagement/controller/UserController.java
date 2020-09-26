package com.capg.flightmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightmanagement.controller.UserController;
import com.capg.flightmanagement.dto.CreateUserRequest;
import com.capg.flightmanagement.dto.ForgetPasswordDto;
import com.capg.flightmanagement.dto.UserDetailsDto;
import com.capg.flightmanagement.dto.UserLoginDto;
import com.capg.flightmanagement.exceptions.UserNotFoundException;
import com.capg.flightmanagement.models.User;
import com.capg.flightmanagement.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger Log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService service;
	
	/**
	 * Adding User
	 * @param userDto
	 * @return
	 */
	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody CreateUserRequest userDto) {
		User user = convert(userDto);
		String result = service.register(user);
		/* UserDetailsDto detailsDto = convertUserDetails(user); */
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}
	
	
	@PostMapping("/login")
	public String doLogin(@RequestBody UserLoginDto loginDto) {
		return service.doLogin(loginDto);
	}
	
	/*
	 * forget password
	 */
	@PostMapping("/recover")
	public ResponseEntity<String> forget(@RequestBody ForgetPasswordDto forgetDto) {
		return new ResponseEntity<String>(service.recover(forgetDto), HttpStatus.OK);
	}
	
	/**
	 * Fetching user by user id
	 * @param userId
	 * @return
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDetailsDto> fetchById(@PathVariable("id") int userId) {
		User user = service.fetchById(userId);
		UserDetailsDto detailsDto = convertUserDetails(user);
		ResponseEntity<UserDetailsDto> response = new ResponseEntity<UserDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}
		
	
	/**
	 * Fetching all users
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<User>> fetchAll() {
		List<User> users = service.fetchAllUsers();
		ResponseEntity<List<User>> response = new ResponseEntity<>(users, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Deleting user by user id
	 * @param userId
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteTheater(@PathVariable("id") int userId) {
		Boolean result = service.delete(userId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}

	public UserDetailsDto convertUserDetails(User user) {
		UserDetailsDto detailsDto = new UserDetailsDto();
		detailsDto.setUserId(user.getUserId());
		detailsDto.setUserType(user.getUserType());
		detailsDto.setUserName(user.getUserName());
		detailsDto.setUserPassword(user.getUserPassword());
		detailsDto.setUserPhone(user.getUserPhone());
		detailsDto.setEmail(user.getEmail());
		return detailsDto;
	}

	public User convert(CreateUserRequest userDto) {
		User user = new User();
		/* user.setUserId(userDto.getUserId()); */
		user.setUserName(userDto.getUserName());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserType(userDto.getUserType());
		user.setUserPhone(userDto.getUserPhone());
		user.setEmail(userDto.getEmail());
		return user;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(UserNotFoundException ex) {
		Log.error("handleUserNotFound()", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		Log.error("handleAll()", ex);// this will get logged
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
}
