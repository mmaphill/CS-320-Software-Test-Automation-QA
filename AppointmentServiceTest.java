package com.appointmentservice.appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	private AppointmentService appointments;
	private Appointment appointment;
	
	@BeforeEach
	void testSetUp() {
		appointments = new AppointmentService();
		appointment = new Appointment("00001","05/11/2026","Here for my appointment");
	}
	
	// Test Add Appointment
	@Test
	void testAddAppointment() {
		assertDoesNotThrow(() -> appointments.addAppointment(appointment));
	}
	
	@Test
	void testAddDuplicateAppointment() {
		appointments.addAppointment(appointment);
		assertThrows(IllegalArgumentException.class, () -> appointments.addAppointment(appointment));
	}
	
	// Test Delete Appointment
	@Test
	void testDeleteAppointment() {
		appointments.addAppointment(appointment);
		assertDoesNotThrow(() -> appointments.deleteAppointement(appointment.getAppointmentId()));
	}
	
	@Test
	void testDeleteNonExistentAppointment() {
		assertThrows(IllegalArgumentException.class, () -> appointments.deleteAppointement("1234"));
	}
}
