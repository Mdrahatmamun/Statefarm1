package com.statefarm1.qa.utils;

public enum DataMap {
	
	ZipCode("Zip Code"), FirstName("First Name"), LastName("Last Name"), Address("Address"), Apt("Apt"), DOB("DOB"), SubText("Expected Text");
	

	private String value;
	
	private DataMap(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
