package com.nisum.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nisum.Utility.ActionHelper;
import com.nisum.Utility.WaitHelper;

public class HomePage {
	WebDriver driver;
	WaitHelper waithelper;
	ActionHelper actionhelper;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='topnav-cookware ']")
	WebElement cookwareLink;

	@FindBy(xpath = "(//a[contains(text(),'Tea Kettles')])[1]")
	WebElement teakettleLink;


/*	@SuppressWarnings("deprecation")
	public void waitForElementclickable(WebElement ele) throws NumberFormatException, Exception {
		long timeout = FileReaderManager.getInstance().getConfigReader().getExplicitWait();
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withTimeout(timeout, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}*/

	public void clickonTeaKettle() throws NumberFormatException, Exception {
		waithelper = new WaitHelper(driver);
		actionhelper = new ActionHelper(driver);
		actionhelper.actionMethod(cookwareLink);
		waithelper.waitForElementclickable(teakettleLink);
		actionhelper.actionMethodwithClick(teakettleLink);
	}

}
