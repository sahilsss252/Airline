package com.lti.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.FlightDetails;
import com.lti.core.exceptions.HrExceptions;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean addFlight(FlightDetails flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		manager.persist(flightDetails);
		return false;
	}
	
	
}
