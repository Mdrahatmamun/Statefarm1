package com.statefarm1.qa.object;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.statefarm1.qa.common.Common;
import com.statefarm1.qa.utils.AutoData;

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
	
	@FindBy(xpath = "//input[@id='street2']")
	WebElement aptElement;
	
	@FindBy(xpath = "//input[@id='date_of_birth']")
	WebElement dobElement;

	@FindBy(xpath = "//label[@for='termsIDCheckbox']")
	WebElement acceptButtonElement;

	@FindBy(xpath = "//button[@id='btnContinue']")
	WebElement submitElement;
	
	@FindBy(xpath = "//h1[text()='Sorry – Our System Has Timed Out']")
	WebElement pageTextElement;


	private void inputFirstName(String firstName) {
		commons.inputValues(inputFirstNameElement, firstName);
	}

	private void inputLastName(String lastName) {
		commons.inputValues(inputLastNameElement, lastName);
	}

	private void inputHomeAddress(String address) {
		commons.inputValues(addressElement, address);
	}
	
	private void inputApt(String apt) {
		commons.inputValues(aptElement, apt);
	}
	
	private void inputDob(String dob) {
		commons.inputValues(dobElement, dob);
	}
	
	private void acceptButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", acceptButtonElement);
		commons.click(acceptButtonElement);
	}
	
	private void nextButton() {
		commons.click(submitElement);
	}
	
	private void verifyPageText(String text) {
		assertEquals(commons.getText(pageTextElement), text);
	}
		
	
			

	public void autoQuotePageSteps(String firstName, String lastName,  String address, String apt, String dob, String text) {
		inputFirstName(firstName);
		inputLastName(lastName);
		inputHomeAddress(address);
		inputApt(apt);
		inputDob(dob);
		acceptButton();
		nextButton();
		verifyPageText(text);
		
	}
	public void autoQuotePageSteps(AutoData autoData) {
		inputFirstName(autoData.getFirstName());
		inputLastName(autoData.getLastName());
		inputHomeAddress(autoData.getAddress());
		inputApt(autoData.getApt());
		inputDob(autoData.getDob());
		acceptButton();
		nextButton();
		verifyPageText(autoData.getExpectedText());
		
	}
}
