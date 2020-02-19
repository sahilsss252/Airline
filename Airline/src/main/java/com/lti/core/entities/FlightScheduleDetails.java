package com.lti.core.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="FLIGHT_SCHEDULE_DETAILS")
@SequenceGenerator(name = "seq", sequenceName = "FLIGHT_SCHEDULE_SEQUENCE", allocationSize = 1, initialValue = 100)
public class FlightScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int scheduleId;
	private LocalDate departureDate;
	private String arrival;
	private String departure;
	private int economySeats;
	private int economyPrice;
	private int businessSeats;
	private int businessPrice;
	
	@ManyToOne
	@JoinColumn(name = "flightId")//fk
	private FlightDetails flightDetails;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalTime() {
		return arrival;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrival = arrivalTime;
	}
	public String getDepartureTime() {
		return departure;
	}
	public void setDepartureTime(String departureTime) {
		this.departure = departureTime;
	}
	public int getEcomonySeats() {
		return economySeats;
	}
	public void setEcomonySeats(int ecomonySeats) {
		this.economySeats = ecomonySeats;
	}
	public int getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(int economyPrice) {
		this.economyPrice = economyPrice;
	}
	public int getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}
	public int getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(int businessPrice) {
		this.businessPrice = businessPrice;
	}
	public FlightDetails getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}
	public FlightScheduleDetails() {
		super();
	}
	public FlightScheduleDetails(int scheduleId, LocalDate departureDate, String arrivalTime, String departureTime,
			int ecomonySeats, int economyPrice, int businessSeats, int businessPrice, FlightDetails flightDetails) {
		super();
		this.scheduleId = scheduleId;
		this.departureDate = departureDate;
		this.arrival = arrivalTime;
		this.departure = departureTime;
		this.economySeats = ecomonySeats;
		this.economyPrice = economyPrice;
		this.businessSeats = businessSeats;
		this.businessPrice = businessPrice;
		this.flightDetails = flightDetails;
	}
	@Override
	public String toString() {
		return "FlightScheduleDetails [scheduleId=" + scheduleId + ", departureDate=" + departureDate + ", arrivalTime="
				+ arrival + ", departureTime=" + departure+ ", ecomonySeats=" + economySeats
				+ ", economyPrice=" + economyPrice + ", businessSeats=" + businessSeats + ", businessPrice="
				+ businessPrice + ", flightDetails=" + flightDetails + "]";
	}
	
	
	
	
	
	
}
