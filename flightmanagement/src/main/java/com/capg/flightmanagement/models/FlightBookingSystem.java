package com.capg.flightmanagement.models;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "flight_booking_tbl")
@SequenceGenerator(name = "booking_id", initialValue = 2013310115)
public class FlightBookingSystem {
	
	private String passangerName;
	private  int age;
	private String gender;
	private Date bookingDate;
	private BigInteger bookingId;
	private String source;
	private String destination;
	private String emailId;
	private String billingAddress;
	private BigInteger contactNumber;
	
	public FlightBookingSystem() {
	}
	public FlightBookingSystem(String passangerName, int age, String gender, Date bookingDate, BigInteger bookingId,
			String source, String destination, String emailId,  String billingAddress, BigInteger contactNumber) {
		super();
		this.passangerName = passangerName;
		this.age = age;
		this.gender = gender;
		this.bookingDate = bookingDate;
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.emailId = emailId;
		this.billingAddress = billingAddress;
		this.contactNumber = contactNumber;
	}
	@Column(name = "passanger_name", nullable = false)
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	@Column(name = "age", nullable = false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "booking_date", nullable = false)
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "booking_id")
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	@Column(name = "source", nullable = false)
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Column(name = "destination", nullable = false)
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Column(name = "email_id", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name = "billing_address", nullable = false)
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	@Column(name = "contact_number", nullable = false)
	public BigInteger getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "FlightBookingSystem [passangerName=" + passangerName + ", age=" + age + ", gender=" + gender
				+ ", bookingDate=" + bookingDate + ", bookingId=" + bookingId + ", source=" + source + ", destination="
				+ destination + ", emailId=" + emailId + ", billingAddress=" + billingAddress + ", contactNumber="
				+ contactNumber + "]";
	}
	
	
	
	
	

}
