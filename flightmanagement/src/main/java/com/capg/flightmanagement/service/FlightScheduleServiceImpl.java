package com.capg.flightmanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.models.Flight;
import com.capg.flightmanagement.models.Schedule;
import com.capg.flightmanagement.models.ScheduledFlight;
import com.capg.flightmanagement.repository.IAirportRepository;
import com.capg.flightmanagement.repository.IFlightRepository;
import com.capg.flightmanagement.repository.IFlightScheduleRepository;
import com.capg.flightmanagement.repository.IScheduleRepository;



@Service
public class FlightScheduleServiceImpl implements IFlightScheduleService{
	
	private static final Logger log=LoggerFactory.getLogger(FlightScheduleServiceImpl.class);
	
	@Autowired
	IFlightScheduleRepository flightScheduleRepository;
	
	@Autowired
	IFlightRepository flightRepository;
	
	@Autowired
	IScheduleRepository scheduleRepository;
	
	@Autowired
	IAirportRepository airportReposidtory;
	
	@Autowired
	IFlightService flightService;
	
	@Override
	@Transactional
	public void scheduleFlight(ScheduledFlight flightSchedule) {
		
		log.debug("Inside scheduleFlight function");
		
		Flight FlightOpt=flightService.viewFlight(flightSchedule.getFlight().getFlightNumber());
		flightSchedule.setAvailableSeats(FlightOpt.getSeatCapacity());
		
		scheduleRepository.save(flightSchedule.getSchedule());
		
		flightScheduleRepository.save(flightSchedule);
	}
	
	@Override
	@Transactional
	public Optional<ScheduledFlight> viewScheduledFlights(int id){
		
		log.debug("Inside viewScheduledFlights by id function in FlightScheduleController");
		
		Optional<ScheduledFlight> flightScheduleOpt=flightScheduleRepository.findById(id);
		
		return flightScheduleOpt;
	}
	
	@Override
	@Transactional
	public List<ScheduledFlight> viewScheduledFlights(Airport arrival, Airport destination, LocalDate date) {
		
		
		
		log.debug("Inside viewScheduledFlights by parameters function in FlightSchedule Service");
		
		List<ScheduledFlight> FlightScheduleList=flightScheduleRepository.getFlightScheduleByAirport(arrival, destination);
		
		List<ScheduledFlight> FlightsOnScheduleList=new ArrayList<>();
	
		
		for (ScheduledFlight flightSchedule : FlightScheduleList) {
			Schedule schedule=flightSchedule.getSchedule();
			if(schedule.getDepartureTime().toLocalDate().equals(date)) {
				FlightsOnScheduleList.add(flightSchedule);
			}
		}
		
		return FlightsOnScheduleList;
		
				
	}
	
	@Override
	@Transactional
	public void deleteScheduledFlight(int id) {
		
		log.debug("Inside deleteScheduledFlight function in FlightScheduleService class");
		
		String scheduleId=flightScheduleRepository.findById(id).get().getSchedule().getScheduleId();
		
		
		flightScheduleRepository.deleteById(id);
		scheduleRepository.deleteById(scheduleId);
	}
	
	@Override
	@Transactional
	public void modifyScheduledFlight(ScheduledFlight flightSchedule) {
		
		log.debug("Inside modifyScheduledFlight function in FlightScheduleService class");
		
		scheduleRepository.save(flightSchedule.getSchedule());
		
		flightScheduleRepository.save(flightSchedule);
		
	}
	
	@Override
	@Transactional
	public List<ScheduledFlight> viewScheduledFlights(){
		
		log.debug("Inside viewScheduledFlights function in FlightScheduleService class");
		
		List<ScheduledFlight> flightScheduleList=flightScheduleRepository.findAll();
		
		return flightScheduleList;
				
		
	}
	
	@Override
	@Transactional
	public String validateScheduledFlight(ScheduledFlight flightSchedule){
		
		int id=flightSchedule.getScheduleFlightId();
		Flight flight=flightSchedule.getFlight();
		Schedule schedule=flightSchedule.getSchedule();
		
		
		Optional<ScheduledFlight> FlightScheduleOpt=flightScheduleRepository.findById(id);
		
		if(FlightScheduleOpt.isPresent()) {
			return "Flight Schedule with this ID already exists!!";
		}
		
		
		
		Optional<Flight> FlightOpt=flightRepository.findById(flight.getFlightNumber());
		
		if(!FlightOpt.isPresent()) {
			return "No Flight with flight Number "+flight.getFlightNumber()+" exists!!";
		}
		
		
		Airport source=schedule.getSourceAirport();
		Optional<Airport> AirportSourceOpt=airportReposidtory.findById(source.getAirportCode());
		if(!AirportSourceOpt.isPresent()) {
			return "No source airport exists of code "+source.getAirportCode();
		}
		
		Airport destination=schedule.getDestinationAirport();
		Optional<Airport> AirportDestinationOpt=airportReposidtory.findById(destination.getAirportCode());
		if(!AirportDestinationOpt.isPresent()) {
			return "No destination airport exists of code "+destination.getAirportCode();
		}
		
		LocalDateTime arrivalTime=schedule.getArrivalTime();
		int status=arrivalTime.toLocalDate().compareTo(LocalDate.now());
		if(status<1) {
			return "Arrival date should be greater than present date";
		}
		
		LocalDateTime departureTime=schedule.getDepartureTime();
		int status2=departureTime.toLocalDate().compareTo(LocalDate.now());
		if(status2<1) {
			return "Departure time should be greater than present date";
		}
		
		
		return "valid data";
		
		
	}
	

}

