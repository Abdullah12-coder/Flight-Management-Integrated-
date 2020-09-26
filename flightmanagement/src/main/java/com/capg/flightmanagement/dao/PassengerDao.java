package com.capg.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.Passenger;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, String>{

}