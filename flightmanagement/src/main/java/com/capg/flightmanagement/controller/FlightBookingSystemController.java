package com.capg.flightmanagement.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightmanagement.models.FlightBookingSystem;
import com.capg.flightmanagement.service.FlightBookingSystemService;

/***************************************Author : Mukul Garg********************************************************************/

@RestController
@RequestMapping("/api/v1")
public class FlightBookingSystemController {

	@Autowired
	private FlightBookingSystemService service;

	/*************************************** This method is used to booked the flight tickets**********************************/

	@PostMapping("/flightbookings")
	public String flightBookings(@RequestBody FlightBookingSystem flightBookingSystem) {
		return service.flightBookings(flightBookingSystem);

	}

	/*************************************** This method is used view the status of the booked tickets***************************/

	@GetMapping("/getbookings/{bookingId}")
	public List<FlightBookingSystem> getBookings(@PathVariable BigInteger bookingId) {
		return service.getBookings(bookingId);
	}

	
	/*************************************** This method is used to delete the booked ticket***********************************/
	@DeleteMapping("/cancelbookings/{bookingId}")
	public String cancelBookings(@PathVariable BigInteger bookingId) {
		return service.cancelBookings(bookingId);

	}

}

