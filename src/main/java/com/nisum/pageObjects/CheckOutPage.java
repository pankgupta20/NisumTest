package com.nisum.pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutPage {
	WebDriver driver;
	HomePage homepage;
	ProductDetailsPage productdetailspage;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="updates[0].moveToSFL")
	WebElement saveLaterBtn;
	
	@FindBy(xpath="//a[contains(text(),'1 saved item')]")
	WebElement saveItemLink;
	
	@FindBy(xpath="//div[@class='cart-table-row-title']")
	WebElement savedItemName;
	
	public void clickSaveBtn() throws NumberFormatException, Exception{
		homepage = new HomePage(driver);		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveLaterBtn);
		homepage.waitForElementclickable(saveLaterBtn);	
		homepage.actionMethodwithClick(saveLaterBtn);
		
		productdetailspage = new ProductDetailsPage(driver);
		String savedItemName = getItemText();
		Assert.assertEquals(savedItemName, productdetailspage.productName);	
	}
	
	public String getItemText(){
		String getText = savedItemName.getText();
		return getText;
	}
}
