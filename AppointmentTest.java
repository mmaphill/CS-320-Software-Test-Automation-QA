package com.appointmentservice.appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	private Appointment appointment;
	
	@BeforeEach
	void testSetUp() {
		appointment = new Appointment("00001","05/11/2026","Here for my appointment");
	}
	
	@Test
	void testAppointment() {
		assertTrue(appointment.getAppointmentId().equals("00001"));
		assertTrue(appointment.getAppointmentDate().equals("05/11/2026"));
		assertTrue(appointment.getAppointmentDescription().equals("Here for my appointment"));
	}
	
	// Test Appointment IDs
	@Test
	void testAppointmentIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment("01234567890","05/11/2026","Here for my appointment"));
	}
	
	@Test
	void testAppointmentIdNull() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment(null,"05/11/2026","Here for my appointment"));
	}
	
	// Test Appointment Dates
	@Test
	void testAppointmentDateInvalidFormat() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment("00001","2026-11-05","Here for my appointment"));
	}
	
	@Test
	void testAppointmentDateInThePast() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment("00001","06/15/2004","Here for my appointment")); 
	}
	
	@Test
	void testAppointmentDateNull() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment("0001",null,"Here for my appointment"));
	}
	
	// Test Appointment Descriptions
	@Test
	void testAppointmentDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment("00001","05/11/2026","If an individual to create a description for their appiontment that was too long, it would look something like this"));
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> appointment = new Appointment("00001","05/11/2026",null));
	}
}
