package com.capg.flightmanagement;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.models.Airport;
import com.capg.flightmanagement.service.IAirportService;

@SpringBootTest
class AirportTests {
	
	@Autowired
	IAirportService airportService;

	
	@Test
	public void fetchAirport_1() {
		Airport airport = new Airport("IGI123","IGI","Delhi");
		Airport result = airportService.fetchAirportById("IGI123");
		Assertions.assertEquals(result, airport);
	}
	
	@Test
	public void fetchAirport_2() {
		Executable executable = () -> airportService.fetchAirportById("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
	
	@Test
	public void deleteAirport_1() {
		Airport airport = new Airport("SHE485","IGI","Delhi");
		airportService.addAirport(airport);
		String executable = airportService.removeAirport("SHE485");
		String expected="Deleted";
		Assertions.assertEquals(expected, executable);
	}
	
	@Test public void deleteAirport_2() {
		Executable executable = () -> airportService.removeAirport("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
	
	@Test
	public void updateAirport_1() {
		Airport airport = new Airport("IGI123","IGI","Delhi");
		airportService.addAirport(airport);
		String actual = airportService.updateAirport(airport);
		String expected="Updated";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test public void updateAirport_2() {
		Airport airport = new Airport("I123","IGI","Delhi");
		Executable executable = () -> airportService.updateAirport(airport);
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
}
