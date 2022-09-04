package com.statefarm1.qa.tests;

import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;

public class AutoQuoteTest extends BaseClass{

	@Test
	public void testAutoQuote() {
		homePage.homepageSteps("Get an insurance quote", "11218");
		autoQuote.autoQuotePageSteps("John", "Wick", "145 Chester ave", "c3", "12311981", "Sorry – Our System Has Timed Out");
	}
}
