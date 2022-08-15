package com.statefarm1.qa.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.statefarm1.qa.common.Common;

public class AutoQuotePage {

	Common commons;
	WebDriver driver;

	public AutoQuotePage(WebDriver driver, Common commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}

	@FindBy(css = "input#first_name")
	WebElement inputFirstNameElement;

	@FindBy(name = "lastName")
	WebElement inputLastNameElement;

	@FindBy(xpath = "//input[@name='welcomeAddress.street1']")
	WebElement addressElement;

	@FindBy(xpath = "//input[@id='date_of_birth']")
	WebElement dobElement;

	@FindBy(name = "acceptingTermsAndConditions")
	WebElement acceptButtonElement;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement submitElement;

	@FindBy(xpath = "//button[@name='continueFairCreditReport']")
	WebElement submitElement2;

	@FindBy(id = "addVehicleButton")
	WebElement clickElement2;

	private void inputFirstName(String value) {
		commons.inputValues(inputFirstNameElement, value);
	}

	private void lastName(String value) {
		commons.inputValues(inputLastNameElement, value);
	}

	private void homeAddress(String value) {
		commons.inputValues(addressElement, value);
	}

	private void dob(String value) {
		commons.inputValues(dobElement, value);
	}
	
	private void acceptButton() {
		commons.click(acceptButtonElement);
	}
	
	private void submitbutton() {
		commons.click(submitElement);
	}
		
	
			

	public void autoQuotePageSteps(String value, String address, String city) {
		inputFirstName(value);
		lastName(value);
		homeAddress(value);
		dob(value);
		acceptButton();
		submitbutton();
		

	}

}
