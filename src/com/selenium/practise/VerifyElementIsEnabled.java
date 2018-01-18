package com.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyElementIsEnabled {
  WebDriver driver;
  
  @BeforeTest
  public void openBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
	   driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.facebook.com");
  }
  @AfterTest
  public void tearDown() {
	  if (driver != null)
			driver.close(); 
		  
  }
  @Test
  public void verifyCreateAccountIsEnabled() {
	  WebElement createAccountButton = driver.findElement(By.id("u_0_17"));
	  boolean flag =createAccountButton.isEnabled();
	  System.out.println("Is Create Account Enabled :" +flag);
	  Assert.assertTrue(flag);
  }
}
