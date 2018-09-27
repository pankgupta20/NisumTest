package com.nisum.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	HomePage homepage;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='subCatListContainer']/ul/li[1]/div/div/a/span/img")
	WebElement FirstTeaKettleLink;
	
	@FindBy(xpath="//a[@class='stickyOverlayMinimizeButton']")
	WebElement AlertClose;


	
	public void selectItem() throws NumberFormatException, Exception {
		homepage = new HomePage(driver);
		homepage.waitForElementclickable(AlertClose);		
		AlertClose.click();
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FirstTeaKettleLink);
			homepage.waitForElementclickable(FirstTeaKettleLink);
			homepage.actionMethodwithClick(FirstTeaKettleLink);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
