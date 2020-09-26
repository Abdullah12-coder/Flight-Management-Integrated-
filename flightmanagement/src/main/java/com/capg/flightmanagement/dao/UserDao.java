package com.capg.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightmanagement.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
