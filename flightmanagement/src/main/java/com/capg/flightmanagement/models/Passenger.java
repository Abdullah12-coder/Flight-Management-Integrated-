package com.capg.flightmanagement.models;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger_details")
public class Passenger {
	
	private BigInteger pnrNumber;
	private String passengerName;
	private int passengerAge;
	@Id
	private String passengerUIN;
	private double luggage;
	private String gender;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(BigInteger pnrNumber, String passengerName, int passengerAge, String passengerUIN,
			double luggage, String gender) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
		this.gender = gender;
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
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(String passengerUIN) {
		this.passengerUIN = passengerUIN;
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