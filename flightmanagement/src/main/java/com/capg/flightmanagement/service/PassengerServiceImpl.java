package com.capg.flightmanagement.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.flightmanagement.dao.PassengerDao;
import com.capg.flightmanagement.exceptions.PassengerNotFoundException;
import com.capg.flightmanagement.models.Passenger;

@Service
@Transactional
public class PassengerServiceImpl implements IPassengerService{
	
	@Autowired
	private PassengerDao dao;
	
	@Autowired
	private IPassengerService service;
	
	@Override
	public Passenger addPassenger(Passenger p) {
		Passenger passenger = dao.save(p);
		return passenger;
	}

	@Override
	public Passenger findPassengerByUin(String uin) {
		Optional<Passenger> optional = dao.findById(uin);
			if(optional.isPresent()) {
				Passenger passenger = optional.get();
				return passenger;
			}
		throw new PassengerNotFoundException("passenger not found for id="+uin);
	}

	@Override
	public Boolean deletePassenger(String uin) {
		Passenger passenger = findPassengerByUin(uin);
		dao.delete(passenger);
		return true;
	}

	

}
