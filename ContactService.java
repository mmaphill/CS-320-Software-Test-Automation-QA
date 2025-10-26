package com.contactservice.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts = new HashMap<>();
	
	// add a contact to the list of contacts
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists: " + contact.getContactId());
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	// delete a contact using the contact ID
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("No contact found with ID: " + contactId);
		}
		contacts.remove(contactId);
	}
	
	// update fields
	public void updateFirstName(String contactId, String firstName) {
		getContact(contactId).setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) {
		getContact(contactId).setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		getContact(contactId).setPhone(phone);
	}
	
	public void updateAddress(String contactId, String address) {
		getContact(contactId).setAddress(address);
	}
	
	// method to get the contact ID
	public Contact getContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("No contact found with ID: " + contactId);
		}
		return contacts.get(contactId);
	}
}