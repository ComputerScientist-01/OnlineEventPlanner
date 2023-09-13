package com.demo.model;

import java.util.List;

public class Vendor {
	private long vendorId;
	private String name;
	private String address;
	private String email;
	private String contactNumbers; // You may consider using a List<String> for multiple contact numbers
	private String eventPackages;

// Constructors, getters, setters

	public Vendor() {
		// Default constructor
		super();
	}

	public Vendor(long vendorId, String name, String address, String email, String contactNumbers,
			String eventPackages) {
		this.vendorId = vendorId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contactNumbers = contactNumbers;
		this.eventPackages = eventPackages;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(List<String> list) {
		this.contactNumbers = list;
	}

	public String getEventPackages() {
		return eventPackages;
	}

	public void setEventPackages(String eventPackages) {
		this.eventPackages = eventPackages;
	}
}