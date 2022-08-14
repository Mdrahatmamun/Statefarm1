package com.statefarm1.qa.tests;

import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;

public class HomePageTest extends BaseClass {
	
	
	@Test
	
	public void homeActions() {
	homePage.homepageSteps("Get an insurance quote", "11218");
	autoQuote.autoQuotePageSteps("Rahat");
		
		
		
	}

}
