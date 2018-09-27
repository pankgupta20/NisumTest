package com.nisum.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoBasketPage {
	WebDriver driver;
	HomePage homepage;
	public AddtoBasketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "anchor-btn-checkout")
	WebElement checkOutBtn;
	
	public void clickCheckout() throws NumberFormatException, Exception{
		homepage = new HomePage(driver);		
		homepage.actionMethodwithClick(checkOutBtn);
	}

}
