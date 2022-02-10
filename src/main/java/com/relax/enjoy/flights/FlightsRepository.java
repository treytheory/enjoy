package com.relax.enjoy.flights;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*Data repository for querying data from the postgresql DB.*/

@Repository
public interface FlightsRepository 
		extends JpaRepository<Flights, Long>{
	
	
	@Query ("SELECT f FROM Flights f WHERE f.starting = ?1")
	Optional <Flights> findFlightsByLocation(String starting);

}
