package com.capg.flightmanagement.exceptions;

public class PassengerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PassengerNotFoundException(String msg){
        super(msg);
}
}
