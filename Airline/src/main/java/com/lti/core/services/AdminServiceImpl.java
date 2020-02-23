package com.lti.core.services;

import java.time.LocalDate;
import java.time.LocalTime;
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
			LocalTime at=fs.getArrival();
			LocalTime dt=fs.getDeparture();
			int timeBetween=at.getHour()-dt.getHour();
			fsd.setDuration(timeBetween);
			fsd.setEconomySeats(fs.getEconomySeats());
			fsd.setBusinessPrice(fs.getBusinessPrice());
			fsd.setEconomyPrice(fs.getEconomyPrice());
			fsd.setFlightDetails(flightDetails);
			fd.add(fsd);
		}
		flightDetails.setFlightScheduleDetails(fd);
		
		admindao.addFlight(flightDetails);
		
	}

	@Override
	public void deleteFlight(FlightDetails flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		LocalDate ddate=null;
		LocalTime departure=null;
		
		String source=flightDetails.getSource();
		System.out.println(source);
		String destination=flightDetails.getDestination();
		
		FlightSchedule fs=flightDetails.getFlightSchedule();
		List<FlightScheduleDetails> fsd=new ArrayList<>();
		
		FlightScheduleDetails fsd1=new FlightScheduleDetails();
		System.out.println(fs.getDepartureDateinFlightSchedule());
		fsd1.setDepartureDate(fs.getDepartureDateinFlightSchedule());
		fsd1.setDeparture(fs.getDeparture());
//		List<FlightScheduleDetails> fsd= flightDetails.getFlightScheduleDetails();
//		for(FlightScheduleDetails fsd1:fsd){
//		ddate=fsd1.getDepartureDate();
//		departure=fsd1.getDeparture();}
//		String Carrier =flightDetails.getCarrier();
		fsd.add(fsd1);
		flightDetails.setFlightScheduleDetails(fsd);
		admindao.deleteFlight(flightDetails);
		
		
		
		
		
		
	}

	@Override
	public List<FlightDetails> getFlights() throws HrExceptions {
		// TODO Auto-generated method stub
		return admindao.getFlights();
	}

}
