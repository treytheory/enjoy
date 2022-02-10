package com.relax.enjoy.flights;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Command Line Runner for persisting flight data to the Postgresql DB*/

@Configuration
public class FlightsConfig {

	@Bean
	CommandLineRunner commandLineRunner(FlightsRepository repository) {
		return args -> {
			Flights boston = new Flights ("Boston","Chicago",LocalDate.of(2021,Month.JULY,10), 3);
			Flights newyork = new Flights ("New York","Miami",LocalDate.of(2021,Month.AUGUST,7), 1);
			Flights portland = new Flights ("Portland","Providence",LocalDate.of(2021,Month.OCTOBER,15), 3);
			Flights detroit = new Flights ("Detroit","Dallas",LocalDate.of(2021,Month.NOVEMBER,9), 1);
			Flights pittsburg = new Flights ("Pittsburg","San Diego",LocalDate.of(2021,Month.DECEMBER,15), 3);
			Flights cincinatti = new Flights ("Cincinatti","Nashville",LocalDate.of(2021,Month.JULY,21), 1);
			repository.saveAll(List.of(boston, newyork,portland,detroit,pittsburg,cincinatti));
		};
	}
}