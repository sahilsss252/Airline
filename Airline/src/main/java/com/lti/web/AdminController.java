package com.lti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.FlightDetails;

import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="/addFlight",consumes = "APPLICATION/JSON")
	public void addPassenger(@RequestBody FlightDetails flightDetails) throws HrExceptions{
		//System.out.println(userDetails);
		
			adminService.addFlight(flightDetails);
			
		
		//return true;
	}
	
}
