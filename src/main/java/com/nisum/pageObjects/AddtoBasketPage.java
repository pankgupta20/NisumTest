package com.nisum.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.Utility.ActionHelper;

public class AddtoBasketPage {
	WebDriver driver;
	ActionHelper actionhelper;

	public AddtoBasketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "anchor-btn-checkout")
	WebElement checkOutBtn;

	public void clickCheckout() throws NumberFormatException, Exception {
		actionhelper = new ActionHelper(driver);
		actionhelper.actionMethodwithClick(checkOutBtn);
	}

}
