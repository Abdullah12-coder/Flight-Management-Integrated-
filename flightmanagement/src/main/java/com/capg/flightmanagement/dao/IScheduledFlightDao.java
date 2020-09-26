package com.capg.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.flightmanagement.models.ScheduledFlight;

public interface IScheduledFlightDao extends JpaRepository<ScheduledFlight, Integer> {

}
