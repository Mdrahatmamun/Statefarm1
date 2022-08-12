package com.statefarm.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.statefarm.qa.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Configuration configuaration = new Configuration(null);
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.get(configuaration.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		
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
	
	public WebDriver getDriver () {
		return driver;
	}

}
