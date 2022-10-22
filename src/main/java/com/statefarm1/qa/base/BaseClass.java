package com.statefarm1.qa.base;



import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.statefarm1.qa.common.Common;
import com.statefarm1.qa.common.CommonWaits;
import com.statefarm1.qa.object.AutoQuotePage;
import com.statefarm1.qa.object.HomePage;
import com.statefarm1.qa.utils.Configuration;
import com.statefarm1.reporting.ExtentManager;
import com.statefarm1.reporting.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Configuration configuration = Configuration.getInstance();
	

	WebDriver driver;
	WebDriverWait wait;
	ExtentReports extent;
	
	protected Common commons;
	CommonWaits waits;
	protected HomePage homePage;
	protected AutoQuotePage autoQuote;
	
	@BeforeSuite
	public void initiatingReport() {
		extent = ExtentManager.initiatingReport();
	}
	
	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.creatingTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
		
	}
	
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}
		if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "TEST PASSED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "TEST SKIPPED");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "TEST FAILED \n" + result.getThrowable());
			ExtentTestManager.getTest().addScreenCaptureFromPath(commons.getScreenshot(method.getName()));
		}
	}
	
	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver(). setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		
		}
		return driver;
		
		
	}
	
	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new Common(driver, waits);
		homePage = new HomePage(driver, commons);
		autoQuote = new AutoQuotePage(driver, commons);
	}
	
	
	public WebDriver getDriver () {
		return driver;
	}
	

	@AfterMethod
	public void terminate() {
		driver.quit();
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
