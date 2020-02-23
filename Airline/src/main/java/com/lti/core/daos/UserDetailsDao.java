package com.lti.core.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface UserDetailsDao {

	public boolean userRegistration(UserDetails userDetails) throws HrExceptions;
	public List<FlightDetails> getFlights(String source,String destination,LocalDate departureDate) throws HrExceptions;
	public List<UserDetails> isValid(UserDetails userDetails);
}
