package com.nisum.pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver;
	HomePage homepage;
	public String productName;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Add to Cart']")
	WebElement AddtoCartBtn;
	
	@FindBy(xpath="//div[@class='pip-summary']/h1")
	WebElement ItemName;
	
	public String getItemName(){
		String getName = ItemName.getText();
		return getName;
	}
	
	public void clickonAddtoCart() throws NumberFormatException, Exception{
		homepage = new HomePage(driver);		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddtoCartBtn);
		homepage.waitForElementclickable(AddtoCartBtn);
		productName = getItemName();
		homepage.actionMethodwithClick(AddtoCartBtn);
	}

}
