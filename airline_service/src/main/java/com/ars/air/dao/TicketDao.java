package com.ars.air.dao;

import java.time.LocalDate;

import com.ars.air.entity.Airline;
import com.ars.air.entity.Flight;
import com.ars.air.entity.Passenger;
import com.ars.air.entity.TicketBooking;

public interface TicketDao {

	TicketBooking bookFlight(Airline airline,Passenger p,LocalDate date,Flight f,int no_of_passenger,float total_fare,int available_seat);
	void cancelBooking(int id);
	TicketBooking getTicket(int id);
} 
