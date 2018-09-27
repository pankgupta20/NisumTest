package com.nisum.Utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nisum.managers.FileReaderManager;

public class WaitHelper {
	WebDriver driver;
	
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
	}
	
	@SuppressWarnings("deprecation")
	public void waitForElementclickable(WebElement ele) throws NumberFormatException, Exception {
		long timeout = FileReaderManager.getInstance().getConfigReader().getExplicitWait();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withTimeout(timeout, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	@SuppressWarnings("deprecation")
	public void waitForElementvisible(WebElement ele, String text) throws NumberFormatException, Exception {
		long timeout = FileReaderManager.getInstance().getConfigReader().getExplicitWait();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withTimeout(timeout, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

	public void waitforelementvisiblejs(WebElement ele) {
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) driver).executeScript(js, ele);
	}

	public void waitforelementclickablejs(WebElement ele) {
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) driver).executeScript(js, ele);
		ele.click();
	}
}
	
