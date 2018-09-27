package com.nisum.driverScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.nisum.Utility.ResourceHelper;
import com.nisum.configReader.ConfigFileReader;
import com.nisum.managers.WebDriverManager;

public class DriverScript {
	public WebDriver driver;
	public ITestResult result;
	WebDriverManager webDriverManager;
	ConfigFileReader config;
	ResourceHelper resourcehelper;
	ConfigFileReader filereader;

	
	public DriverScript(){			
		filereader = new ConfigFileReader();
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		filereader = new ConfigFileReader();
		config =  new ConfigFileReader();
	}

	@BeforeTest
	public void setUp() {
		driver.get(config.getApplicationUrl());
	}




	@AfterTest(alwaysRun = true)
	public void endTest() {
		driver.quit();
/*		extent.endTest(test);
		extent.flush();*/
	}

}
