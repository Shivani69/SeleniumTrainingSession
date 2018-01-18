package com.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyElementIsPresent {
 WebDriver driver;
 
 
 @BeforeTest
 public void openBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
	   driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
 }
 @AfterTest
 public void tearDown() {
	  if (driver != null)
			driver.close(); 	   
}
 @Test
 public void verifyrightClickMeText() {
	WebElement rightClickMe =driver.findElement(By.cssSelector(".context-menu-one,btn.btn-neutral"));
	boolean flag = rightClickMe.isDisplayed();
	System.out.println("Text is Present :"+flag);
	System.out.println("Text is:"+rightClickMe.getText());
	Assert.assertTrue(flag);
 }
 
 }
