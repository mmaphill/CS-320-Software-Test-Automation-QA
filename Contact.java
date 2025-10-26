package com.contactservice.contact;

public class Contact {
	// Fields
	private final String contactId;
	private String lastName;
	private String firstName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Contact ID must be non-null and no more than 10 characters");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name must be non-null and no more than 10 characters.");
		}
		if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must be non-null and no more than 10 characters.");
        }
		if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone Number must be non-null and exactly 10 digits.");
        }
		if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null and no more than 30 characters.");
        }
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	
	// Getters
	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhone() { return phone; }
	public String getAddress() { return address; }
	
	// Setters
	public void setFirstName(String firstName) { 
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name must be non-null and no more than 10 characters.");
		}
		this.firstName = firstName; 
	}
	public void setLastName(String lastName) { 
		if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must be non-null and no more than 10 characters.");
        }
		this.lastName = lastName; 
	}
	public void setPhone(String phone) { 
		if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone Number must be non-null and exactly 10 digits.");
        }
		this.phone = phone; 
	}
	public void setAddress(String address) { 
		if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null and no more than 30 characters.");
        }
		this.address = address; 
	}
}