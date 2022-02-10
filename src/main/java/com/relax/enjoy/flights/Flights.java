package com.relax.enjoy.flights;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*Define and initialize the variables
Adds constructors, getters, setters and stringTo for the Flights program*/

@Entity
@Table
public class Flights {
	@Id
	@SequenceGenerator(
			name = "flights_sequence",
			sequenceName = "flights_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "flights_sequence"
			)
	
	private Long id;
	private String starting;
	private String destination;
	private LocalDate ftd;
	private Integer passengers;
	
	public Flights() {
	}

	public Flights(Long id, 
			String starting, 
			String destination, 
			LocalDate ftd, 
			Integer passengers) {
		this.id = id;
		this.starting = starting;
		this.destination = destination;
		this.ftd = ftd;
		this.passengers = passengers;
	}

	public Flights(String starting, 
			String destination, 
			LocalDate ftd, 
			Integer passengers) {
		this.starting = starting;
		this.destination = destination;
		this.ftd = ftd;
		this.passengers = passengers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStarting() {
		return starting;
	}

	public void setStarting(String starting) {
		this.starting = starting;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFtd() {
		return ftd;
	}

	public void setFtd(LocalDate ftd) {
		this.ftd = ftd;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "flights [id=" + id + ", starting=" + starting + ", destination=" + destination + ", ftd=" + ftd
				+ ", passengers=" + passengers + "]";
	}
	
}
