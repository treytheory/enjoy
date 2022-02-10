package com.relax.enjoy.flights;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Flight Service class that handles the business logic for the RESTful API.*/ 

@Service
public class FlightsService {
	
	private final FlightsRepository flightsRepository;
	
	
	@Autowired
	public FlightsService(FlightsRepository flightsRepository) {
		this.flightsRepository = flightsRepository;
	}


	public List<Flights> getFlights() {
		return flightsRepository.findAll();
				
		/*
		 * new Flights(1L,"Boston","Chicago",LocalDate.of(2021,Month.MARCH,10), 3)
		 */
				
	}


	public void addNewFlights(Flights flights) {
		Optional<Flights> flightsOptional = flightsRepository
				.findFlightsByLocation(flights.getStarting());
		System.out.println(flights);
		
		if(flightsOptional.isPresent()) {
			throw new IllegalStateException("Flight Already Exists");
		}
		
		flightsRepository.save(flights);
	}


	public void deleteFlights(Long flightsId) {
		boolean exists = flightsRepository.existsById(flightsId);
		
		if (!exists) {
			throw new IllegalStateException("Flight " + flightsId + " does not Exist");
		}
		
		flightsRepository.deleteById(flightsId);
		
	}


	@Transactional
	public void updateFlights(Long flightsId, String starting, String destination) {
		Flights flights = flightsRepository.findById(flightsId).orElseThrow(()-> new IllegalStateException("Flight " + flightsId + " does not Exist"));
		
	if (starting !=null && starting.length() > 0 && !Objects.equals(flights.getStarting(), starting)) {
		flights.setStarting(starting);
	}
	
	if (destination !=null && destination.length() > 0 && !Objects.equals(flights.getDestination(), destination)) {
		flights.setDestination(destination);
	}
	
	}

}
