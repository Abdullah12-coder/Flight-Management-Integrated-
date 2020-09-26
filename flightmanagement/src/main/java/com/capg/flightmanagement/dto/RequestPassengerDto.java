package com.capg.flightmanagement.dto;

import java.math.BigInteger;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RequestPassengerDto {

	private String passengerUIN;
	private BigInteger pnrNumber;
	private String passengerName;
	private Integer passengerAge;
	private double luggage;
	private String gender;

	public String getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(String passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
