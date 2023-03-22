package com.ars.air.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Table(name="booking_details")
public class TicketBooking {
@Id
@GenericGenerator(name="ticket_no",strategy = "com.ars.airge.entity.TicketNoGenerator")
@GeneratedValue(generator="ticket_no")
private int ticketId;
private int no_of_passenger;
private float total_fare;
@Column(name="travel_date")
private LocalDate date=LocalDate.now();
@OneToOne
private Flight fid;
@OneToOne
private Airline aid;
@OneToOne
private Passenger pid;

}
