

package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;




@Repository
public class UserDetailsImpl implements UserDetailsDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
	@Override
	public boolean userRegistration(UserDetails userDetails) {
		manager.persist(userDetails);
		
		
		
		
		return true;
	}

	@Override
	public List<FlightDetails> getFlights() throws HrExceptions {
		String query="select e from FlightDetails e join fetch e.flightScheduleDetails b where e.source='delhi' and e.destination='pune'";
		Query q=manager.createQuery(query);
		//System.out.println(q.getSingleResult());
		List<FlightDetails> lst=q.getResultList();
		//List<FlightDetails> u=q.getResultList();
		
		return lst;
	}

//	@Override
//	public List<FlightDetails> getFlights() throws HrExceptions {
//		// TODO Auto-generated method stub
//		String query="select e from FlightDetails e join fetch e.flightScheduleDetails b where e.flightId=501";
//		Query q=manager.createQuery(query);
//		List<FlightDetails> lst=q.getResultList();
//		//List<FlightDetails> u=q.getResultList();
//		
//		return lst;
//	}

//	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
//	@Override
//	public boolean insertDept(Department d) throws HrException {
//		// TODO Auto-generated method stub
//	    manager.persist(d);
//		return true;
//	}
	

}
