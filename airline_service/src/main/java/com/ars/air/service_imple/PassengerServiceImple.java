package com.ars.air.service_imple;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ars.air.dao.PassengerDao;
import com.ars.air.daoimple.PassengerDaoImple;
import com.ars.air.entity.Passenger;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.PassengerDTO;
import com.ars.air.service.PassengerService;

public class PassengerServiceImple implements PassengerService {
	PassengerDao pdao=new PassengerDaoImple();
	@Override
	public void savePassenger(Passenger passenger) {
	pdao.savePassenger(passenger);
	}

	@Override
	public boolean login(String username, String passwword) {
	
		return pdao.Plogin(username, passwword);
	}

	@Override
	public PassengerDTO getPassengerById(int id) throws GlobalException {
		Passenger passenger1=pdao.getPassenger(id);		
		return new ModelMapper().map(passenger1, PassengerDTO.class);
	}

	@Override
	public PassengerDTO updatePassenger(int id, Passenger passenger) {
		Passenger p=pdao.updatePassenger(id, passenger);
		return new ModelMapper().map(p, PassengerDTO.class);
	}

	@Override
	public void deletePassenger(int id) throws PersistenceException {
		pdao.deletePassenger(id);	
	}

}
