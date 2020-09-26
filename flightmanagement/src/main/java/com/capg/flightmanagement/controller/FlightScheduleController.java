package com.capg.flightmanagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightmanagement.exceptions.FlightScheduleNotFoundException;
import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.models.ScheduledFlight;
import com.capg.flightmanagement.service.IAirportService;
import com.capg.flightmanagement.service.IFlightScheduleService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/flightSchedule")
public class FlightScheduleController {
	
	private static final Logger log=LoggerFactory.getLogger(FlightScheduleController.class);
	
	@Autowired
	private IFlightScheduleService flightScheduleServive;
		
	@Autowired
	private IAirportService airportService;

	@PostMapping(path="/add")
	public String add(@RequestBody ScheduledFlight flightSchedule)throws FlightScheduleNotFoundException
	{
		if(flightSchedule.getScheduleFlightId()==0||flightSchedule.getFlight().getFlightNumber()==null||flightSchedule.getSchedule().getArrivalTime()==null||flightSchedule.getSchedule().getDepartureTime()==null||flightSchedule.getSchedule().getSourceAirport()==null||flightSchedule.getSchedule().getDestinationAirport()==null ) {
			throw new FlightScheduleNotFoundException();
		}
		
		log.debug("Inside add method in controller class");
		
		String validate=flightScheduleServive.validateScheduledFlight(flightSchedule);
		
		if("valid data".equals(validate)) {
			
			
			flightScheduleServive.scheduleFlight(flightSchedule);
			validate="Added successfully";
		}
		
		
		return validate;
		
	}
	
	@GetMapping("/viewByAirport")
	public List<ScheduledFlight> getFlightOnDate(@RequestParam("source")String source,@RequestParam("destination") String destination,@RequestParam("date")String Date)throws FlightScheduleNotFoundException{
		
		if(source==null||destination==null||Date==null) {
			throw new FlightScheduleNotFoundException();
		}
		
		Airport airport1=airportService.getAirportByName(source);
		Airport airport2=airportService.getAirportByName(source);
		LocalDate date=LocalDate.parse(Date);
		
		if(date.compareTo(LocalDate.now())<1) {
			throw new FlightScheduleNotFoundException();
		}
		
		List<ScheduledFlight> FlightScheduleList=flightScheduleServive.viewScheduledFlights(airport1,airport2,date);
		
		if(FlightScheduleList.isEmpty()) {
			throw new FlightScheduleNotFoundException();
		}
		
		return FlightScheduleList;
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws FlightScheduleNotFoundException {
		
		log.debug("Inside delete method in controller class");
		
		Optional<ScheduledFlight> flightScheduleOpt=flightScheduleServive.viewScheduledFlights(id);
		
		if(!flightScheduleOpt.isPresent()) {
			throw new FlightScheduleNotFoundException();
		}
		
		
		
		flightScheduleServive.deleteScheduledFlight(id);
		
		return "Deleted succesfully";
	}
	
	@PostMapping("/update")
	public String update(@RequestBody ScheduledFlight flightSchedule) {
		
		log.debug("Inside update method in controller class");
		
		flightScheduleServive.modifyScheduledFlight(flightSchedule);
		
		return "updated";
		
	}
	@GetMapping("/viewById")
	public ScheduledFlight getFlightScheduleById(@RequestParam("id")int id) throws FlightScheduleNotFoundException{
		
		log.debug("Inside getFlightScheduleById in controller class");
		
		Optional<ScheduledFlight> flightScheduleOpt=flightScheduleServive.viewScheduledFlights(id);
		
		if(!flightScheduleOpt.isPresent()) {
			throw new FlightScheduleNotFoundException();
		}
		
		ScheduledFlight flightSchedule=flightScheduleOpt.get();
		
		return flightSchedule;
	}
	
	@GetMapping("/viewAll")
	public List<ScheduledFlight> viewAll(){
		List<ScheduledFlight> flightScheduleList=flightScheduleServive.viewScheduledFlights();
		return flightScheduleList;
	}
	
}

