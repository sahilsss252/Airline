package com.lti.core.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="FLIGHT_SCHEDULE_DETAILS")
@SequenceGenerator(name = "seqSchedule", sequenceName = "FLIGHT_SCHEDULE_SEQUENCE", allocationSize = 1, initialValue = 100)
public class FlightScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSchedule")
	private int scheduleId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate departureDate;
	
	private String arrival;
	private String departure;
	private int economySeats;
	private int economyPrice;
	private int businessSeats;
	private int businessPrice;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="flightId")//fk
	private FlightDetails flightDetails;
	/*private int flightId;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}*/
	
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
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrivalTime) {
		this.arrival = arrivalTime;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departureTime) {
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
				+ businessPrice + "]";
	}
	/*@Override
	public String toString() {
		return "FlightScheduleDetails [scheduleId=" + scheduleId + ", departureDate=" + departureDate + ", arrival="
				+ arrival + ", departure=" + departure + ", economySeats=" + economySeats + ", economyPrice="
				+ economyPrice + ", businessSeats=" + businessSeats + ", businessPrice=" + businessPrice + ", flightId="
				+ flightId + "]";
	}*/
}
