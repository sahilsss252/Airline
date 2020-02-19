package com.lti.core.daos;

import com.lti.core.entities.FlightDetails;
import com.lti.core.exceptions.HrExceptions;

public interface AdminDao {

	public boolean addFlight(FlightDetails flightDetails) throws HrExceptions;
}
