package com.statefarm1.qa.object;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.statefarm1.qa.common.Common;

public class HomePage {

	Common commons;
	WebDriver driver;

	public HomePage(WebDriver driver, Common commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}
	
	@FindBy (xpath =  "//h2[text()='Get an insurance quote']")
	WebElement h2TextElement;
	
	@FindBy (xpath = "//img[@class='-oneX-header-logo']")
	WebElement logoElement;
	
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	WebElement zipCodElement;

	@FindBy(xpath = "//button[@id='quote-main-zip-btn']")
	WebElement clickStartQuoteElement;

	
	private void verifyHeader2Txt(String expectedTxt) {
		assertEquals(commons.getText(h2TextElement), expectedTxt);	
	
}
	
	private void verifyLogo() {
		commons.isDisplay(logoElement);
	}
	
	private void inputZipcode(String zipValue){
		commons.inputValues(zipCodElement, zipValue);
	}
	
	private void verifyStartQuoteButton () {
		commons.buttonEnabled(clickStartQuoteElement);
	}
	
	private void clickStartQuoteButton () {
		commons.click(clickStartQuoteElement);
	}

	
	public void homepageSteps(String expectedTxt,String zipValue) {
		verifyHeader2Txt(expectedTxt);
		verifyLogo();
		inputZipcode(zipValue);
		verifyStartQuoteButton();
		clickStartQuoteButton();
	}
}





