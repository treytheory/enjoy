package com.relax.enjoy.flights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*Spring Controller for the RESTful API. This class file contains the PUT, GET, DELETE, and POST methods.*/

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/flights")
public class FlightsController {
	
	private final FlightsService flightsService;
		
	@Autowired
	public FlightsController(FlightsService flightsService) {
		this.flightsService = flightsService;
	}

	@GetMapping
	public List<Flights> getFlights() {
		return flightsService.getFlights();

	}
	
	@PostMapping
	public void registerNewFlights(@RequestBody Flights flights) {
		flightsService.addNewFlights(flights);
	}
	
	@DeleteMapping(path = "{flightsId}")
	public void deleteFlights(@PathVariable ("flightsId") Long flightsId ) {
		flightsService.deleteFlights(flightsId);
	}
	
	@PutMapping(path = "{flightsId}")
	public void updateFlights(
			@PathVariable("flightsId") Long flightsId,
			@RequestParam(required = false) String starting,
			@RequestParam(required = false) String destination) {
			flightsService.updateFlights(flightsId, starting, destination);
			}
	
}
	

	
