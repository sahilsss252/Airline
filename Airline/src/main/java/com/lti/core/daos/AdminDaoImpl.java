package com.lti.core.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightScheduleDetails;
import com.lti.core.exceptions.HrExceptions;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addFlight(FlightDetails flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		System.out.println("in dao Flight Details" + flightDetails);

		/*FlightDetails fd = (FlightDetails) manager.merge(flightDetails);
		System.out.println("======================> " + fd.getFlightId());*/
		
		/*for(FlightScheduleDetails fs : flightDetails.getFlightScheduleDetails()) {
			fs.setFlightDetails(flightDetails);
			//manager.merge(fs);
		}*/
		
		manager.persist(flightDetails);
		
		/*List<FlightScheduleDetails> scheduleDetails = flightDetails.getFlightScheduleDetails();
		for(FlightScheduleDetails scheduleDetail:scheduleDetails){
			scheduleDetail.set
		}*/
	}
}
