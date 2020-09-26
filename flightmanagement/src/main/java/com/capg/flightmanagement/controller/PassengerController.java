package com.capg.flightmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flightmanagement.dto.RequestPassengerDto;
import com.capg.flightmanagement.exceptions.PassengerNotFoundException;
import com.capg.flightmanagement.models.Passenger;
import com.capg.flightmanagement.service.IPassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerService service;

	/* add passengers */
	@PostMapping("/add")
	public ResponseEntity<Boolean> addPassengers(@RequestBody RequestPassengerDto requestPassengersData) {
			Passenger passenger = convertFromDtoToPassenger(requestPassengersData);
			passenger = service.addPassenger(passenger);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		return reponse;
	}

	/** convert passengerdtodetails to passengerdetails **/
	public Passenger convertFromDtoToPassenger(RequestPassengerDto requestData) {
		Passenger passenger = new Passenger();
		passenger.setPassengerUIN(requestData.getPassengerUIN());
		passenger.setPassengerName(requestData.getPassengerName());
		passenger.setPassengerAge(requestData.getPassengerAge());
		passenger.setPnrNumber(requestData.getPnrNumber());
		passenger.setLuggage(requestData.getLuggage());
		passenger.setGender(requestData.getGender());
		return passenger;
	}
	
	/* find passenger using UIN */
	@GetMapping("/getbyuin/{uin}")
	public ResponseEntity<Passenger> findPassengerByUin(@PathVariable("uin") String uin) {
		Passenger passenger = service.findPassengerByUin(uin);
		ResponseEntity<Passenger> reponse = new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
		return reponse;
	}

	@DeleteMapping("/deletebyuin/{uin}")
	public ResponseEntity<Boolean> deletePassengerByUin(@PathVariable("uin") String uin) {
		Boolean result = service.deletePassenger(uin);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}

	/* exception handler used for handling PassengerNotFoundException */
	@ExceptionHandler(PassengerNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(PassengerNotFoundException exception) {
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}
	
}
