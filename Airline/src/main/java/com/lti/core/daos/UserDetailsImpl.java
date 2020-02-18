package com.lti.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.UserDetails;



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

//	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
//	@Override
//	public boolean insertDept(Department d) throws HrException {
//		// TODO Auto-generated method stub
//	    manager.persist(d);
//		return true;
//	}
	

}
