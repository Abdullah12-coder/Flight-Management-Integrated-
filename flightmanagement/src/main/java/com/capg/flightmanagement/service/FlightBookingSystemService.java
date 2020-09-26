package com.capg.flightmanagement.service;


import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.models.FlightBookingSystem;

public interface FlightBookingSystemService {

	String flightBookings(FlightBookingSystem flightBookingSystem);

	List<FlightBookingSystem> getBookings(BigInteger bookingId);

	String cancelBookings(BigInteger bookingId);

}

