package com.nisum.pageObjects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nisum.managers.FileReaderManager;

public class HomePage {
	WebDriver driver;	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='topnav-cookware ']")
	WebElement cookwareLink;

	@FindBy(xpath = "(//a[contains(text(),'Tea Kettles')])[1]")
	WebElement teakettleLink;
	
	public void actionMethod(WebElement ele){
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public void actionMethodwithClick(WebElement ele){
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		ele.click();
	}
	
	public void waitForElementclickable(WebElement ele) throws NumberFormatException, Exception {
		long timeout = FileReaderManager.getInstance().getConfigReader().getExplicitWait();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withTimeout(timeout, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void clickonTeaKettle() throws NumberFormatException, Exception{
		actionMethod(cookwareLink);
		this.waitForElementclickable(teakettleLink);	
		this.actionMethodwithClick(teakettleLink);
	}
	
}
