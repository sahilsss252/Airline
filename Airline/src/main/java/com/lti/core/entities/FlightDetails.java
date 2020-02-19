package com.lti.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="FLIGHT_DETAILS")
@SequenceGenerator(name = "seq", sequenceName = "FLIGHT_DETAILS_SEQUENCE", allocationSize = 1, initialValue = 100)
public class FlightDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int flightId;
	private String source;
	private String destination;
	private String carrier;
	private int duration;
	
	@OneToMany(mappedBy = "flightDetails",cascade=CascadeType.ALL)
	private List<FlightScheduleDetails> flightScheduleDetails;
	
	
	public List<FlightScheduleDetails> getFlightScheduleDetails() {
		return flightScheduleDetails;
	}
	public void setFlightScheduleDetails(List<FlightScheduleDetails> flightScheduleDetails) {
		this.flightScheduleDetails = flightScheduleDetails;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public FlightDetails() {
		super();
	}
	public FlightDetails(int flightId, String source, String destination, String carrier, int duration,
			List<FlightScheduleDetails> flightScheduleDetails) {
		super();
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.carrier = carrier;
		this.duration = duration;
		this.flightScheduleDetails = flightScheduleDetails;
	}
	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", source=" + source + ", destination=" + destination
				+ ", carrier=" + carrier + ", duration=" + duration + ", flightScheduleDetails=" + flightScheduleDetails
				+ "]";
	}
	
	
}
