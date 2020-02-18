package com.lti.core.services;

import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface PassengerService {

	public boolean addPassenger(UserDetails details)  throws HrExceptions;
	
}
