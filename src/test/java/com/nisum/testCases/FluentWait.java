/*package com.nisum.testCases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class FluentWait {
static WebDriver driver;
	public static void main(String[] args) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withtimeout(10,TimeUnit.SECONDS)
				.pollingevery(1,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
			 WebElement element = driver.findElement(By.xpath("//*[@id='softwareTestingMaterial']"));
			 String getTextOnPage = element.getText();
			 if(getTextOnPage.equals("Software Testing Material - DEMO PAGE")){
			 System.out.println(getTextOnPage);
			 return element;
			 }else{
			 System.out.println("FluentWait Failed");
			 return null;
			 }
			 }
			 });

	}

}
*/