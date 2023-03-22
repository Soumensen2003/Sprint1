package com.ars.air.service;

import javax.persistence.PersistenceException;

import com.ars.air.entity.Airline;
import com.ars.air.model.AirlineDTO;



public interface AirlineService {
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	AirlineDTO getAirlineByName(String name);
	AirlineDTO updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;

}
