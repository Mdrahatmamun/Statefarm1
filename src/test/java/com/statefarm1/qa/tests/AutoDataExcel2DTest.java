package com.statefarm1.qa.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;
import com.statefarm1.qa.utils.ExcelUtil;

public class AutoDataExcel2DTest extends BaseClass{
	
	@DataProvider(name = "autoData2DExcel")
	public Object[][] autoData(){
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		return excelUtil.dataObjects();
	}

	@Test(enabled = true, dataProvider = "autoData2DExcel")
	public void getAutoQuote(String zipCode, String firstName, String lastName, String address, String apt, String dob,
			String expectedText) {
		homePage.homepageSteps(zipCode);
		autoQuote.autoQuotePageSteps(firstName, lastName, address, apt, dob, expectedText);
		
	}
}
