package com.ars.air.dao;

import javax.persistence.PersistenceException;

import com.ars.air.entity.Airline;



public interface AirlineDao {
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	Airline getAirlineByName(String name);
	Airline updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;
}
