package com.statefarm1.qa.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;

public class AutoTestParameter extends BaseClass{

	@Parameters("zip")
	@Test(enabled = true)
	public void startAutoQuote(String zip) {
		homePage.homepageSteps(zip);
	}
}
