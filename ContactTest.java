package com.contactservice.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	private Contact contact;

	@BeforeEach
	void testSetUp() {
		contact = new Contact("0123456789","Phill","Nunez","9789424183","18 Boston Rd");
	}
	
	
	@Test
	void testContact() {
		assertTrue(contact.getContactId().equals("0123456789"));
		assertTrue(contact.getFirstName().equals("Phill"));
		assertTrue(contact.getLastName().equals("Nunez"));
		assertTrue(contact.getPhone().equals("9789424183"));
		assertTrue(contact.getAddress().equals("18 Boston Rd"));
	}
	
	@Test
	void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("01234567890","Phill","Nunez","9789424183","18 Boston Rd"));
	}
	
	@Test
	void testNullContactId() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact(null,"Phill","Nunez","9789424183","18 Boston Rd"));
	}
	
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789","This Name is Too Long","Nunez","9789424183","18 Boston Rd"));
	}
	
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789",null,"Nunez","97894284183","18 Boston Rd"));
	}
	
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("123","Phill","This Name is Too Long","97894284183","18 Boston Rd"));
	}
	
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("123","Phill",null,"97894284183","18 Boston Rd"));
	}
	
	@Test
	void testPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789","Phill","Nunez","978942418","18 Boston Rd"));
	}
	
	@Test
	void testPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789","Phill","Nunez","97894241833","18 Boston Rd"));
	}
	
	@Test
	void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789","Phill","Nunez",null,"18 Boston Rd"));
	}
	
	@Test
	void testAdrressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789","Phill","Nunez","9789424183","18 Boston Rd 18 Boston Rd 18 Boston Rd"));
	}
	
	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> contact = new Contact("0123456789","Phill","Nunez","9789424183",null));
	}
	
	@Test
	void testSetValidFirstName() {
		assertDoesNotThrow(() -> contact.setFirstName("Felipe"));
	}
	
	@Test
	void testSetFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("This Name is Too Long"));
	}
	
	@Test
	void testSetNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}
	
	@Test
	void testSetValidLastName() {
		assertDoesNotThrow(() -> contact.setLastName("Summers"));
	}
	
	@Test
	void testSetLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("This Name is Too Long"));
	}
	
	@Test
	void testSetNullLastName() {
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}
	
	@Test
	void testSetValidPhone() {
		assertDoesNotThrow(() -> contact.setPhone("9999424183"));
	}
	
	@Test
	void testSetPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("978942418"));
	}
	
	@Test
	void testSetPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("97894241833"));
	}
	
	@Test
	void testSetNullPhone() {
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
	}
	
	@Test
	void testSetValidAddress() {
		assertDoesNotThrow(() -> contact.setAddress("123 My House Rd"));
	}
	
	@Test
	void testSetAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("18 Boston Rd 18 Boston Rd 18 Boston Rd"));
	}
	
	@Test
	void testSetNullAddress() {
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}
}
