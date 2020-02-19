package com.lti.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.FlightDetails;
import com.lti.core.exceptions.HrExceptions;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addFlight(FlightDetails flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		manager.persist(flightDetails);
		return false;
	}
	
	
}
