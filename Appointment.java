package com.appointmentservice.appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Appointment {
	// Fields
	private final String appointmentId;
	private String dateString;
	private LocalDate appointmentDate;
	private LocalDate today = LocalDate.now();
	private String appointmentDescription;
	
	// Constructor
	public Appointment(String appointmentId, String dateString, String appointmentDescription) {
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Appointment IDs must not be null and no greater than 10 characters");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		try {
			appointmentDate = LocalDate.parse(dateString, formatter);
		}
		catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Invalid date format. Please use MM/dd/yyyy");
		}
		if (appointmentDate == null || appointmentDate.isBefore(today)) {
			throw new IllegalArgumentException("Appointment Date must not be null and can not be scheduled in the past");
		}
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Appointmend Descriptions must not be null and no greather than 50 characters");
		}
		
		this.appointmentId = appointmentId;
		this.dateString = dateString;
		this.appointmentDescription = appointmentDescription;
	}
	
	// Getters
	public String getAppointmentId() { return appointmentId; }
	public String getAppointmentDate() { return dateString; }
	public String getAppointmentDescription() { return appointmentDescription; }
}