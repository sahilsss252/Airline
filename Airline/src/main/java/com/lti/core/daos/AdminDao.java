package com.lti.core.daos;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightScheduleDetails;
import com.lti.core.exceptions.HrExceptions;

public interface AdminDao {

	public void addFlight(FlightDetails flightDetails) throws HrExceptions;
}
