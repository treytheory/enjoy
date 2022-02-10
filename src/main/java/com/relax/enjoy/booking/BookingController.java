package com.relax.enjoy.booking;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/flights")
	public List<Object> getBooking(){
		
		String url = "http://localhost:8080/flights";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(objects);
	}
}
