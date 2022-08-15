package com.statefarm1.qa.base;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.statefarm1.qa.common.Common;
import com.statefarm1.qa.common.CommonWaits;
import com.statefarm1.qa.object.AutoQuotePage;
import com.statefarm1.qa.object.HomePage;
import com.statefarm1.qa.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Configuration configuration = new Configuration(null);
	

	WebDriver driver;
	WebDriverWait wait;
	
	protected Common commons;
	CommonWaits waits;
	protected HomePage homePage;
	protected AutoQuotePage autoQuote;
	
	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("explicitWait"))));
		initClasses();
		
	}
	
	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver(). setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.edgedriver().setup();
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
//		driver.quit();
	}

}
