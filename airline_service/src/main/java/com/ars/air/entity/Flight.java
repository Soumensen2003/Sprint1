package com.ars.air.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="flights")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int flight_id;
	@Column(name = "avilable_seats")
private int avilableSeats;
	@Column(name="total_seats")
private int totalSeats;
	@Column(length = 50)
private String travellerClass;
private String time;
private LocalDate date;
@Column(length = 50)
private String source;
@Column(length = 50)
private String destination;
@ManyToOne
@JoinColumn(name="airline_id")
private Airline airline;
}
