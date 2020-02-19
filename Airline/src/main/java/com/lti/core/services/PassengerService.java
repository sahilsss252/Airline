package com.lti.core.services;

import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface PassengerService {

	public boolean addPassenger(UserDetails details)  throws HrExceptions;
	public List<FlightDetails> getFlights() throws HrExceptions;
}
