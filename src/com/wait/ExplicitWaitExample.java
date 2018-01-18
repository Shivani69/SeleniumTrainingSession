package com.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		 System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		   driver =new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   driver.get("https://www.facebook.com");
	}
	@AfterMethod
	   public void tearDown() {
			  if (driver != null)
					driver.close(); 	   
	}
	@Test
	public boolean verifySubmitButton() {
		WebDriverWait  wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type ='submit']")) );
		
		WebElement submitButton = driver.findElement(By.cssSelector("button[type ='submit']"));
		boolean isDisplayed = submitButton.isEnabled();
		return isDisplayed;
	}
	@Test
	public void verifySampleTest() {
		Assert.assertTrue(verifySubmitButton());
	}
}
	
