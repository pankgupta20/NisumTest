package com.nisum.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nisum.Utility.ActionHelper;
import com.nisum.Utility.WaitHelper;

public class ProductsPage {
	WebDriver driver;
	HomePage homepage;
	WaitHelper waithelper;
	ActionHelper actionhelper;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='subCatListContainer']/ul/li[1]/div/div/a/span/img")
	WebElement FirstTeaKettleLink;

	@FindBy(xpath = "//a[@class='stickyOverlayMinimizeButton']")
	WebElement AlertClose;

	public void selectItem() throws NumberFormatException, Exception {
		waithelper = new WaitHelper(driver);
		actionhelper = new ActionHelper(driver);
		try {
			if (AlertClose.isDisplayed()) {
				waithelper.waitForElementclickable(AlertClose);
				AlertClose.click();
			}
		} catch (NoSuchElementException nosucheleex) {
			throw new Exception("Alert not found on product page");
		} finally {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FirstTeaKettleLink);
				waithelper.waitForElementclickable(FirstTeaKettleLink);
				actionhelper.actionMethodwithClick(FirstTeaKettleLink);
			} catch (NumberFormatException ne) {
				ne.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
