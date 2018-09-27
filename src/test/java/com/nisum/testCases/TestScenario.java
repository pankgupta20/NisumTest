package com.nisum.testCases;

import org.testng.annotations.Test;

import com.nisum.Utility.AlertHelper;
import com.nisum.Utility.BrowserHelper;
import com.nisum.driverScript.DriverScript;
import com.nisum.pageObjects.AddtoBasketPage;
import com.nisum.pageObjects.CheckOutPage;
import com.nisum.pageObjects.HomePage;
import com.nisum.pageObjects.ProductDetailsPage;
import com.nisum.pageObjects.ProductsPage;

public class TestScenario extends DriverScript {

	HomePage homepage;
	AddtoBasketPage addtobasketpage;
	CheckOutPage checkoutpage;
	ProductDetailsPage productdetailspage;
	ProductsPage productspage;
	BrowserHelper browserhelper;
	AlertHelper alerthelper;

	public TestScenario() {
		super();
		homepage = new HomePage(driver);
		productspage = new ProductsPage(driver);
		productdetailspage = new ProductDetailsPage(driver);
		addtobasketpage = new AddtoBasketPage(driver);
		checkoutpage = new CheckOutPage(driver);
		browserhelper = new BrowserHelper(driver);
		alerthelper = new AlertHelper(driver);
	}

	@Test
	public void ScenarioTest() {
		try {
			homepage.clickonTeaKettle();
			productspage.selectItem();
			productdetailspage.clickonAddtoCart();
			addtobasketpage.clickCheckout();
			checkoutpage.clickSaveBtn();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
