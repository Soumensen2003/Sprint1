package com.ars.air.service_imple;


import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ars.air.dao.AirlineDao;
import com.ars.air.dao.FlightDAO;
import com.ars.air.dao.PassengerDao;
import com.ars.air.dao.TicketDao;
import com.ars.air.daoimple.AirlineDaoImpl;
import com.ars.air.daoimple.FlightDAOimpl;
import com.ars.air.daoimple.PassengerDaoImple;
import com.ars.air.daoimple.TicketDaoImpl;
import com.ars.air.entity.Airline;
import com.ars.air.entity.Flight;
import com.ars.air.entity.Passenger;
import com.ars.air.entity.TicketBooking;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.TicketBookingDTO;
import com.ars.air.service.TicketService;

public class TicketServiceImple implements TicketService{
FlightDAO fdao=new FlightDAOimpl();
AirlineDao adao=new AirlineDaoImpl();
PassengerDao pdao=new PassengerDaoImple();
TicketDao tdao=new TicketDaoImpl();
	
@Override
public TicketBookingDTO bookFlight(int flight_id, LocalDate date, String pEmail, int no_of_passenger,
		String airName) {
	Flight flight=fdao.getFlight(flight_id);
	if(flight.getAvilableSeats()>no_of_passenger)
	{
		Passenger p=pdao.getPassengerByEmail(pEmail);
		Airline airline=adao.getAirlineByName(airName);
		float totalfare=(float) (airline.getFare()*no_of_passenger);
		int avilable_seat=(flight.getAvilableSeats()-no_of_passenger);
		TicketBooking bookedTicket=tdao.bookFlight(airline, p, date, flight, no_of_passenger, totalfare, avilable_seat);
	return new ModelMapper().map(bookedTicket,TicketBookingDTO.class);
	}
	return null;
}
	@Override
	public void cancelBooking(int id) {
		tdao.cancelBooking(id);
		
	}

	@Override
	public TicketBookingDTO getTicket(int id) {
		TicketBooking tick=tdao.getTicket(id);
		if(tick!=null)
			return new ModelMapper().map(tick, TicketBookingDTO.class);
	
	
	throw new GlobalException("Passenger details not exist!!!");
	}

	
	

}






	
	






