package com.ars.air.service_imple;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ars.air.dao.AirlineDao;
import com.ars.air.daoimple.AirlineDaoImpl;
import com.ars.air.entity.Airline;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.AirlineDTO;
import com.ars.air.service.AirlineService;




public class AirlineServiceImpl implements AirlineService{
AirlineDao airlineDAO=new AirlineDaoImpl();
	@Override
	public void saveAirline(Airline airline) {
		airlineDAO.saveAirline(airline);
		
	}

	@Override
	public void assignAirlineToFlight(int flightId, int airId) {
		airlineDAO.assignAirlineToFlight(flightId, airId);
		
	}

	@Override
	public AirlineDTO getAirlineByName(String name)throws GlobalException {
		Airline airline=airlineDAO.getAirlineByName(name);
		if(airline!=null) {
			return new ModelMapper().map(airline, AirlineDTO.class);
		}
		throw new GlobalException("Airline detalis not exsit!!");
	}

	@Override
	public AirlineDTO updateAirlineById(int id, Airline airline) {
	Airline a= airlineDAO.updateAirlineById(id, airline);
		return new ModelMapper().map(a, AirlineDTO.class);
	}

	@Override
	public void deleteAirline(int id) throws PersistenceException {
	airlineDAO.deleteAirline(id);
		
	}

}