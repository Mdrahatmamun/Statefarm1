package com.statefarm1.qa.tests;

import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;

public class AutoQuoteTest extends BaseClass{

	@Test(groups = "John")
	public void testAutoQuote() {
		homePage.homepageSteps( "11218");
		autoQuote.autoQuotePageSteps("John", "Wick", "145 Chester ave", "c3", "12311981", "Sorry – Our System Has Timed Out");
	}
	
	@Test(groups = "Murad")
	public void testAutoQuote2() {
		homePage.homepageSteps( "11218");
		autoQuote.autoQuotePageSteps("Murad", "Ant", "145 Chester ave", "c3", "12311981", "Sorry – Our System Has Timed Out");
	}
}
