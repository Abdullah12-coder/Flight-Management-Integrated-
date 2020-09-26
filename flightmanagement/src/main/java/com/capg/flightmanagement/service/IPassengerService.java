package com.capg.flightmanagement.service;

import com.capg.flightmanagement.models.Passenger;

public interface IPassengerService {

	Passenger addPassenger(Passenger p);

	Passenger findPassengerByUin(String uin);

	Boolean deletePassenger(String uin);
}