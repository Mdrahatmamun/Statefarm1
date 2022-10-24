package com.statefarm1.qa.tests;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;
import com.statefarm1.qa.utils.ExcelUtil;

public class AutoDataMapTest extends BaseClass {

	@DataProvider(name="excelMap")
	public Object[][] mapData(){
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1];
		/*
		 * objects2d is an two-dimensional array
		 * Object[][] objects2d = new Object[size][1]
		 * define size = basically that many number of rows in dataMap
		 * 1 = is basically each dataMap index has one map
		 */
		for(int i = 0; i < size; i++) {
			objects2d[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2d;
	}
	
	
	@Test(enabled=true, dataProvider = "excelMap" )
	public void getAutoQuoteWithDataMapEnum(Map<String, String>map) {
		homePage.homepageSteps(map);
		autoQuote.autoQuotePageSteps(map);
		}
	
	@Test(enabled=false, dataProvider = "excelMap" )
	public void getAutoQuoteWithMap(Map<String, String>map) {
		homePage.homepageSteps(map.get("Zip Code"));
		autoQuote.autoQuotePageSteps(map.get("First Name"), map.get("Last Name"), map.get("Address"), map.get("Apt"), map.get("DOB"), map.get("Expected Text"));
		}
	
	
	
	
}
