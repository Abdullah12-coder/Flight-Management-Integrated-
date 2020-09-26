package com.capg.flightmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.models.ScheduledFlight;




public interface IFlightScheduleService {
	
	public void scheduleFlight(ScheduledFlight flightSchedule);
	
	public Optional<ScheduledFlight> viewScheduledFlights(int id);
	
	public List<ScheduledFlight> viewScheduledFlights(Airport arrival,Airport destination,LocalDate date);
	
	public void deleteScheduledFlight(int id);
	
	public void modifyScheduledFlight(ScheduledFlight flightSchedule);
	
	public List<ScheduledFlight> viewScheduledFlights();
	
	public String validateScheduledFlight(ScheduledFlight flightSchedule);

}

