package com.capg.flightmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.models.ScheduledFlight;

@Repository
public interface IFlightScheduleRepository extends JpaRepository<ScheduledFlight, Integer>{

	@Query("Select f from ScheduledFlight f join f.schedule s where s.sourceAirport=?1 and s.destinationAirport=?2")
	List<ScheduledFlight> getFlightScheduleByAirport(Airport source,Airport destination);
	
}
