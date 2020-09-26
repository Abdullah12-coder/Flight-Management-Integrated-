package com.capg.flightmanagement.repository;


import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.FlightBookingSystem;

@Repository
public interface FlightBookingSystemRepository extends JpaRepository<FlightBookingSystem, BigInteger> {

	@Query(value = "select * from flight_booking_tbl where booking_id = ?1", nativeQuery = true)
	List<FlightBookingSystem> getBookings(BigInteger bookingId);


}
