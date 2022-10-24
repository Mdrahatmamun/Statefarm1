package com.statefarm1.qa.object;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.statefarm1.qa.common.Common;
import com.statefarm1.qa.utils.AutoData;
import static com.statefarm1.qa.utils.DataMap.*;

public class HomePage {

	Common commons;
	WebDriver driver;

	public HomePage(WebDriver driver, Common commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}
	
	
	@FindBy (xpath = "//img[@class='-oneX-header-logo']")
	WebElement logoElement;
	
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	WebElement zipCodElement;

	@FindBy(xpath = "//button[@id='quote-main-zip-btn']")
	WebElement clickStartQuoteElement;
	
	@FindBy(id = "nyLegacyCloseLinkId")
	WebElement popUpElement;
	
	public void getCurrentUrl() {
		commons.getCurrentUrl(driver);
	}


/*	public void clickAtGetQuote() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getQuotElement);
		commons.click(getQuotElement);
	}*/
	
	public void clickAtPopUp() {
		commons.click(popUpElement);
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

	
	public void homepageSteps(String zipValue) {
		verifyLogo();
		inputZipcode(zipValue);
		verifyStartQuoteButton();
		clickStartQuoteButton();
		clickAtPopUp();
	}
	
	public void homepageSteps(Map<String, String> map) {
		verifyLogo();
		inputZipcode(map.get(ZipCode.getValue()));
		verifyStartQuoteButton();
		clickStartQuoteButton();
		clickAtPopUp();
	}
	
	public void homepageSteps(AutoData autoData) {
		verifyLogo();
		inputZipcode(autoData.getZipCode());
		verifyStartQuoteButton();
		clickStartQuoteButton();
		clickAtPopUp();
	}
}





