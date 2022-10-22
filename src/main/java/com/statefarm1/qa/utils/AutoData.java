package com.statefarm1.qa.utils;

public class AutoData {

	private String zipCode;
	private String firstName;
	private String lastName;
	private String address;
	private String apt;
	private String dob;
	private String expectedText;
	
	public AutoData(String zipCode, String firstName, String lastName, String address, String apt, String dob,
			String expectedText) {
		
		this.zipCode = zipCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.apt = apt;
		this.dob = dob;
		this.expectedText = expectedText;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getApt() {
		return apt;
	}

	public String getDob() {
		return dob;
	}

	public String getExpectedText() {
		return expectedText;
	}

	
	
}
