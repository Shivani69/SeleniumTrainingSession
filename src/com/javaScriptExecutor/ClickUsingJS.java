package com.javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickUsingJS {
	WebDriver driver;
	   
	   @BeforeMethod
	   public void openBrowser() {
		   System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		   driver =new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://www.facebook.com"); 
		   
}
	   @AfterMethod
	   public void tearDown() {
		   if (driver!=null)
			   driver.close();
	   }
	   @Test
	   public void clickAsJavaScript() throws InterruptedException{
		   WebElement createAccountButton = driver.findElement(By.id("u_0_15"));
		   String javaScript ="arguments[0].click();";
		   JavascriptExecutor js =(JavascriptExecutor)driver;
		   js.executeScript(javaScript, createAccountButton);
		   
		   Thread.sleep(3000);
	   }
}
