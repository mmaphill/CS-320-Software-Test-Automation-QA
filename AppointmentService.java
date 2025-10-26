package com.appointmentservice.appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private Map<String, Appointment> appointments = new HashMap<>();
	
	public void addAppointment(Appointment appointment) {
		if (appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("Appointment ID already exists: " + appointment.getAppointmentId());
		}
		appointments.put(appointment.getAppointmentId(), appointment);
	}
	
	public void deleteAppointement(String appointmentId) {
		if (!appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("No appointment Id found with: " + appointmentId);
		}
		appointments.remove(appointmentId);
	}
}