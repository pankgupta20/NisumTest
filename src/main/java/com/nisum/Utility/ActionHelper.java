package com.nisum.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
	WebDriver driver;

	public ActionHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void actionMethodwithClick(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		ele.click();
	}

	public void actionMethod(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

}
