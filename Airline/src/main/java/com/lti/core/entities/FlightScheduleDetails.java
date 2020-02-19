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
@Table(name="FLIGHT_SCHDULE_DETAILS")
@SequenceGenerator(name = "seq", sequenceName = "FLIGHT_SCHEDULE_SEQUENCE", allocationSize = 1, initialValue = 100)
public class FlightScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int scheduleId;
	private LocalDate departureDate;
	private String arrivalTime;
	private String departureTime;
	private int ecomonySeats;
	private int economyPrice;
	private int businessSeats;
	private int businessPrice;
	@ManyToOne
	@JoinColumn(name = "flight_identity")//fk
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
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getEcomonySeats() {
		return ecomonySeats;
	}
	public void setEcomonySeats(int ecomonySeats) {
		this.ecomonySeats = ecomonySeats;
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
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.ecomonySeats = ecomonySeats;
		this.economyPrice = economyPrice;
		this.businessSeats = businessSeats;
		this.businessPrice = businessPrice;
		this.flightDetails = flightDetails;
	}
	@Override
	public String toString() {
		return "FlightScheduleDetails [scheduleId=" + scheduleId + ", departureDate=" + departureDate + ", arrivalTime="
				+ arrivalTime + ", departureTime=" + departureTime + ", ecomonySeats=" + ecomonySeats
				+ ", economyPrice=" + economyPrice + ", businessSeats=" + businessSeats + ", businessPrice="
				+ businessPrice + ", flightDetails=" + flightDetails + "]";
	}
	
	
	
	
	
	
}
