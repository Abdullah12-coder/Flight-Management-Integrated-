package com.capg.flightmanagement.service;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.capg.flightmanagement.models.FlightBookingSystem;
import com.capg.flightmanagement.repository.FlightBookingSystemRepository;

@Service
public class FlightBookingSystemServiceImpl implements FlightBookingSystemService {

	@Autowired
	private FlightBookingSystemRepository repo;

//	--------------------Booking the flight tickets---------------------
	@Override
	public String flightBookings(FlightBookingSystem flightBookingSystem) {
		repo.save(flightBookingSystem);
		return "Your Flight Booked Successfully";
	}

//	--------------------View the Booked ticket status-----------------------

	@Override
	public List<FlightBookingSystem> getBookings(BigInteger bookingId) {
		if (!repo.existsById(bookingId)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Booking Id is Invalid");
		} else {
			return repo.getBookings(bookingId);
		}

	}

//	-----------------------------Cancel the booked tickets--------------------------

	@Override
	public String cancelBookings(BigInteger bookingId) {
		if (!repo.existsById(bookingId)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Booking Id is Invalid");
		} else {
			repo.deleteById(bookingId);
			return "Your booking canceled";
		}
	}
}

