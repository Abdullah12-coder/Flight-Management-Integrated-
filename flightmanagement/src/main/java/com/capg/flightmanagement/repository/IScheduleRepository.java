package com.capg.flightmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, String>{

}
