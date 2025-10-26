package com.contactservice.contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	private ContactService contacts;
	private Contact contact;

	@BeforeEach
	void testSetUp() {
		contacts = new ContactService();
		contact = new Contact("0123456789","Phill","Nunez","9789424183","18 Boston Rd");
	}
	
	// Add Contact Tests
	@Test
	void testAddContact() {
		contacts.addContact(contact);
		Contact retrieved = contacts.getContact("0123456789");
		assertNotNull(retrieved);
		assertEquals("Phill", retrieved.getFirstName());
	}
	
	@Test
	void testAddDuplicate() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.addContact(contact));
	}
	
	@Test
	void testDeleteContact() {
		contacts.addContact(contact);
		assertDoesNotThrow(() -> contacts.deleteContact("0123456789"));
	}
	
	@Test
	void testDeleteNonExistentContact() {
		assertThrows(IllegalArgumentException.class, () -> contacts.deleteContact("999"));
	}
	
	@Test
	void testGetContact() {
		contacts.addContact(contact);
		assertDoesNotThrow(() -> contacts.getContact("0123456789"));
	}
	
	@Test
	void testGetNonExistentContact() {
		assertThrows(IllegalArgumentException.class, () -> contacts.getContact("999"));
	}
	
	@Test
	void testUpdateFirstName() {
		contacts.addContact(contact);
		contacts.updateFirstName("0123456789", "John");
		assertEquals("John", contacts.getContact("0123456789").getFirstName());
	}
	
	@Test
	void testFirstNameTooLong() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updateFirstName("0123456789","Phill&Felipe"));
	}
	
	@Test
	void testFirstNameNull() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updateFirstName("0123456789", null));
	}
	
	@Test
	void testUpdateLastName() {
		contacts.addContact(contact);
		contacts.updateLastName("0123456789", "Doe");
		assertEquals("Doe", contacts.getContact("0123456789").getLastName());
	}
	
	@Test
	void testLastNameTooLong() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updateLastName("0123456789", "NunezSummers"));
	}
	
	@Test
	void testLastNameNull() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updateLastName("0123456789", null));
	}
	
	@Test
	void testUpdatePhone() {
		contacts.addContact(contact);
		contacts.updatePhone("0123456789", "1234567890");
		assertEquals("1234567890", contacts.getContact("0123456789").getPhone());
	}
	
	@Test
	void testPhoneTooShort() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("0123456789", "978942814"));
	}
	
	@Test
	void testPhoneTooLong() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("0123456789", "97894241833"));
	}
	
	@Test
	void testPhoneNull() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updatePhone("0123456789", null));
	}
	
	@Test
	void testUpdateAddress() {
		contacts.addContact(contact);
		contacts.updateAddress("0123456789", "123 My Home");
		assertEquals("123 My Home", contacts.getContact("0123456789").getAddress());
	}
	
	@Test
	void testAddressTooLong() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updateAddress("0123456789", "18 Boston Rd 18 Boston Rd 18 Boston Rd"));
	}
	
	@Test
	void testAddressNull() {
		contacts.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> contacts.updateAddress("0123456789", null));
	}
}
