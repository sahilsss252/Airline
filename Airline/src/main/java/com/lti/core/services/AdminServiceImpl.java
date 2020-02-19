package com.lti.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.AdminDao;
import com.lti.core.entities.FlightDetails;
import com.lti.core.exceptions.HrExceptions;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admindao;
	
	@Override
	public void addFlight(FlightDetails flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		
		boolean b=admindao.addFlight(flightDetails);
		
	}

}
