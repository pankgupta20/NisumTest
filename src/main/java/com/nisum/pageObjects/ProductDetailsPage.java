package com.nisum.pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.Utility.ActionHelper;
import com.nisum.Utility.WaitHelper;

public class ProductDetailsPage {
	WebDriver driver;
	WaitHelper waithelper;
	ActionHelper actionhelper;
	public String productName;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Add to Cart']")
	WebElement AddtoCartBtn;
	
	@FindBy(xpath="//div[@class='pip-summary']/h1")
	WebElement ItemName;
	
	@FindBy(xpath="//label[@for='shipToCustomer0']")
	WebElement shipitem;
	
	public String getItemName(){
		String getName = ItemName.getText();
		return getName;
	}
	
	public void clickonAddtoCart() throws NumberFormatException, Exception{
		waithelper = new WaitHelper(driver);
		actionhelper = new ActionHelper(driver);	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shipitem);
		waithelper.waitForElementclickable(AddtoCartBtn);
		productName = getItemName();
		actionhelper.actionMethodwithClick(AddtoCartBtn);
	}

}
