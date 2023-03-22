package com.ars.air.dao;

import javax.persistence.PersistenceException;

import com.ars.air.entity.Passenger;



public interface PassengerDao {
void savePassenger(Passenger passenger);
boolean Plogin(String userName,String password);
Passenger getPassenger(int id);
Passenger updatePassenger(int id,Passenger passenger);
void deletePassenger(int id)throws PersistenceException;
Passenger getPassengerByEmail(String email);
}

