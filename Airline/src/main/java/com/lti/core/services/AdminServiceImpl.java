package com.lti.core.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.AdminDao;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightSchedule;
import com.lti.core.entities.FlightScheduleDetails;
import com.lti.core.exceptions.HrExceptions;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admindao;

	@Override
	public void addFlight(FlightDetails flightDetails) throws HrExceptions {
		FlightSchedule fs = flightDetails.getFlightSchedule();
		
		List<FlightScheduleDetails> fd = new ArrayList<>();
		
		//LocalDate start = LocalDate.of(fs.getScheduledStartDate().getYear(),fs.getScheduledStartDate().getMonth(),fs.getScheduledStartDate().getDate());
		LocalDate start = fs.getScheduledStartDate(); 
		LocalDate end = start.plusMonths(fs.getDurationInMonths());
		
		long daysBetween = ChronoUnit.DAYS.between(start,end);
		
		for(long l = 0; l < daysBetween; l++) {
			FlightScheduleDetails fsd = new FlightScheduleDetails();
			start = start.plusDays(1);
			fsd.setDepartureDate(start);
			fsd.setArrival(fs.getArrival());
			fsd.setDeparture(fs.getDeparture());
			fsd.setBusinessSeats(fs.getBusinessSeats());
			fsd.setEcomonySeats(fs.getEconomySeats());
			fsd.setBusinessPrice(fs.getBusinessPrice());
			fsd.setEconomyPrice(fs.getEconomyPrice());
			fsd.setFlightDetails(flightDetails);
			fd.add(fsd);
		}
		flightDetails.setFlightScheduleDetails(fd);
		
		admindao.addFlight(flightDetails);
		
	}

}
