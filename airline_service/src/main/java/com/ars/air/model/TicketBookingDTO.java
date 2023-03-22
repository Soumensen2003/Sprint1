package com.ars.air.model;



import java.util.Date;

import com.ars.air.entity.Airline;
import com.ars.air.entity.Flight;
import com.ars.air.entity.Passenger;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TicketBookingDTO {
	
	private int ticketId;
	private int no_of_passenger;
	private double totalFare;
	private Date date=new Date();
	private Flight flightId;
	private Airline airlineId;
	private Passenger passengerId;

}

