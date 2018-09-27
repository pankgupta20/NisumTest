package com.nisum.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static final String chromedriverpath = System.getProperty("user.dir") + "/Utilities/chromedriver.exe";
	private static final String IEdriverpath = System.getProperty("user.dir") + "/Utilities/IEDriverServer.exe";
	

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}


	private WebDriver createDriver() {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty("webdriver.chrome.driver", chromedriverpath);
        	
        	driver = new ChromeDriver();
    		break;
        case IE : 
        	System.setProperty("webdriver.ie.driver",IEdriverpath);
	/*		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			dc.setCapability("requireWindowFocus", true);*/
        	driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
	
	
}
