package com.capg.flightmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.Airport;


@Repository
public interface IAirportRepository extends JpaRepository<Airport, String>{
	
	@Query ("select a.airportName from Airport a where a.airportCode =?1")
	String getAiportNameByCode (String airportCode);

}
