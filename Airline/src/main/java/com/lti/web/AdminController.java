package com.lti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.FlightDetails;

import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="/addFlight",consumes = "APPLICATION/JSON")
	public void addFlight(@RequestBody FlightDetails flightDetails) throws HrExceptions{
		//System.out.println(userDetails);
			//System.out.println(flightDetails.getFlightSchedule());
			adminService.addFlight(flightDetails);
			
	
		//return true;
	}
	
	@GetMapping(value="/viewFlight",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetails> ViewFlights() throws HrExceptions{
		//System.out.println(userDetails);
		
			//System.out.println(passengerService.getFlights());
			return adminService.getFlights();
	}
	@PostMapping(value="/deleteFlight",consumes = "APPLICATION/JSON")
	public void deleteFlight(@RequestBody FlightDetails flightDetails) throws HrExceptions{
		//System.out.println(userDetails);
			//System.out.println(flightDetails.getFlightScheduleDetails());
			adminService.deleteFlight(flightDetails);
			
	
		//return true;
	}
}
