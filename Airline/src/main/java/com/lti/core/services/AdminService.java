package com.lti.core.services;

import com.lti.core.entities.FlightDetails;
import com.lti.core.exceptions.HrExceptions;

public interface AdminService {

	public void addFlight(FlightDetails flightDetails) throws HrExceptions;
	
}
