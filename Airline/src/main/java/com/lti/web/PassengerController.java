package com.lti.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.PassengerService;



@RestController
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;

	@PostMapping(value="/addPassenger",consumes = "APPLICATION/JSON")
	public void addPassenger(@RequestBody UserDetails userDetails) throws HrExceptions{
		System.out.println(userDetails);
		
			boolean b=passengerService.addPassenger(userDetails);
			if(b){
				System.out.println(b);
				
			}
			else
			{
				System.out.println(b);
			}
		
		//return true;
	}
	
//	@PostMapping(value="/addDept",consumes = "application/json")
//	public void getDeptList(@RequestBody Department dept) throws HrException{
//		System.out.println(dept);
//		boolean b=service.createDept(dept);
//		System.out.println(b);
//		service.createDept(dept);
//		
//	}

	
	@GetMapping(value="/getFlight/{source}/{destination}/{departureDate}",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetails> ViewFlights(
			@PathVariable("source") String source,
			@PathVariable("destination") String destination,
			@PathVariable("departureDate") String departureDate) throws HrExceptions{
		//System.out.println(userDetails);
		System.out.println(source);
		//System.out.println(departureDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(departureDate, formatter);
		System.out.println(date);
		return passengerService.getFlights(source, destination, date);
	}
	
	@GetMapping(value="/getFlightAfterLogin/{source}/{destination}/{departureDate}/{flightClass}/{noOfPassengers}",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetails> ViewFlightsafterLogin(
			@PathVariable("source") String source,
			@PathVariable("destination") String destination,
			@PathVariable("departureDate") String departureDate,
			@PathVariable("flightClass") String flightClass,
			@PathVariable("noOfPassengers") int noOfPassengers ) throws HrExceptions{
		//System.out.println(userDetails);
		System.out.println(source);
		//System.out.println(departureDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(departureDate, formatter);
		System.out.println(date);
		List<FlightDetails> flightDetails= passengerService.getFlightsAfterLogin(source, destination, date, flightClass, noOfPassengers);
		System.out.println(flightDetails);
		return flightDetails;
	}
	
	@PostMapping(value="/login",consumes="Application/JSON")
	public @ResponseBody List<UserDetails> isLogin(@RequestBody UserDetails userDetails){
		
		System.out.println(userDetails);
		List<UserDetails>u=passengerService.isValid(userDetails);
		
		System.out.println(u);
		return u;
		
	}
	
	
	@PostMapping(value="/payment",consumes="Application/JSON")
	public @ResponseBody boolean isPaymentDone(@RequestBody UserDetails userDetails){
		
		System.out.println(userDetails);
		List<UserDetails>u=passengerService.isValid(userDetails);
		System.out.println(u);
		return (Boolean) null;
		
	}
	/*@PostMapping(value="/payment",consumes="Application/JSON")
	public @ResponseBody boolean addPassenger(@RequestBody UserDetails userDetails){
		
		System.out.println(userDetails);
		List<UserDetails>u=passengerService.isValid(userDetails);
		System.out.println(u);
		return (Boolean) null;
		
	}*/
	
}
