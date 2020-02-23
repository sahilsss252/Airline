package com.lti.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface PassengerService {

	public boolean addPassenger(UserDetails details)  throws HrExceptions;
	public List<FlightDetails> getFlights(String source, String destination, LocalDate departureDate) throws HrExceptions;
	public List<UserDetails> isValid(UserDetails userDetails);
}
