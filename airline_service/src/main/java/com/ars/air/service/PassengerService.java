package com.ars.air.service;

import javax.persistence.PersistenceException;

import com.ars.air.entity.Passenger;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.PassengerDTO;


public interface PassengerService {
	void savePassenger(Passenger passenger);
	boolean login(String username,String password);
	PassengerDTO getPassengerById(int id) throws GlobalException;
	PassengerDTO updatePassenger(int id,Passenger passenger);
	void deletePassenger(int id) throws PersistenceException;
}
