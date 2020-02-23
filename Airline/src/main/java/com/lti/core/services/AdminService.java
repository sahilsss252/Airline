package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.FlightDetails;
import com.lti.core.exceptions.HrExceptions;

public interface AdminService {

	public void addFlight(FlightDetails flightDetails) throws HrExceptions;
	public void deleteFlight(FlightDetails flightDetails) throws HrExceptions;
	public List<FlightDetails> getFlights() throws HrExceptions;
}
