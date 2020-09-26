package com.capg.flightmanagement.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, BigInteger>{

}
