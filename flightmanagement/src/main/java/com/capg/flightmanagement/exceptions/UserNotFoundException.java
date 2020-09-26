package com.capg.flightmanagement.exceptions;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2564463389454678565L;

	public UserNotFoundException(String msg){
	        super(msg);
}
}
