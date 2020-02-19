package com.lti.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.UserDetailsDao;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	
	@Override
	public boolean addPassenger(UserDetails details) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.userRegistration(details);
	}


	@Override
	public List<FlightDetails> getFlights() throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.getFlights();
	}

	
	
	
}
