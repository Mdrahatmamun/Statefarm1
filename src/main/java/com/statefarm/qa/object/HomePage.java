package com.statefarm.qa.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	Action cAction;
	
	

	public HomePage(WebDriver driver, Action cAction) {
		PageFactory.initElements(driver, this);
		this.cAction = cAction;

}
	
	@FindBy(xpath = "//select[@name='productName']")
	WebElement searchButton;
	
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	WebElement inputElement;
	
	@FindBy(xpath = "//div[@class='quote-zip get-quote_zip-submit -w_mt-20 -w_mb-16 -w_mr-15']")
	WebElement clickElement;
	
	

}
