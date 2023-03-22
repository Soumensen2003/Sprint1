package com.ars.air.service_imple;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ars.air.dao.FlightDAO;
import com.ars.air.daoimple.FlightDAOimpl;
import com.ars.air.entity.Flight;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.FlightDTO;
import com.ars.air.service.FlightService;





public class FlightServiceImpl implements FlightService{
FlightDAO flightDAO=new FlightDAOimpl();
	@Override
	public void saveFlight(Flight flight) {
		flightDAO.saveFlight(flight);
		
	}

	@Override
	public FlightDTO updateFlight(int id, Flight flight) {
		Flight f=flightDAO.updateFlight(id, flight);
		return new ModelMapper().map(f, FlightDTO.class);
	}

	@Override
	public FlightDTO getFlight(int id)throws GlobalException {
		Flight flight=flightDAO.getFlight(id);
		if(flight!=null)
		{
		return new ModelMapper().map(flight, FlightDTO.class);
		}
		throw new GlobalException("Flight detalis not exist");
		}

	@Override
	public void deleteFlight(int id) throws PersistenceException {
	
		flightDAO.deleteFlight(id);
	}

	@Override
	public List<Flight> checkFlight(String from, String to, LocalDate date) {
		
		return flightDAO.checkFlight(from, to, date);
	}

}
