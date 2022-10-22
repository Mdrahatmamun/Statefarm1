package com.statefarm1.qa.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.statefarm1.qa.base.BaseClass;
import com.statefarm1.qa.utils.AutoData;

public class AutoDataTest extends BaseClass{
	
	@DataProvider(name = "autoDataIterator")
	public Iterator<AutoData> autoDataIterator() {
		List<AutoData> list = new ArrayList<AutoData>();
  AutoData autoData1 = new AutoData("11218","John", "Wick", "145 Chester ave", "c3", "12311981", "Sorry – Our System Has Timed Out");
  AutoData autoData2 = new AutoData("11214","Johny", "Wicky", "146 Chester ave", "c3", "12311984", "Sorry – Our System Has Timed Out");
  list.add(autoData1);
  list.add(autoData2);
  return list.iterator();
}
	
	@DataProvider(name = "autoDataObject")
	public Object[][] autoDataObject() {
		  AutoData autoData1 = new AutoData("11218","John", "Wick", "145 Chester ave", "c3", "12311981", "Sorry – Our System Has Timed Out");
		  AutoData autoData2 = new AutoData("11214","Johny", "Wicky", "146 Chester ave", "c3", "12311984", "Sorry – Our System Has Timed Out");
		 	return new Object[][] {{autoData1}, {autoData2}};
	}
	
	@Test(enabled = false, dataProvider = "autoDataObject")
	public void autoQuoteDataObjectTest(AutoData autoData) {
		homePage.homepageSteps(autoData);
		autoQuote.autoQuotePageSteps(autoData);
		
	}
	
	@Test(enabled = true, dataProvider ="autoDataIterator")
	public void autoQuoteDataIteratorTest(AutoData autoData) {
		homePage.homepageSteps(autoData);
		autoQuote.autoQuotePageSteps(autoData);
		
	}
	
}
