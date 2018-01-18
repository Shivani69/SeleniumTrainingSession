package com.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyBoardSample {
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
		   if (driver!=null)
			   driver.close();
	   }
	   @Test
	   public void performDragAndDrop() throws InterruptedException{
		   WebElement text = driver.findElement(By.name("firstname"));
		   Actions builder = new Actions(driver);
		   builder.keyDown(Keys.SHIFT)
		   		  .sendKeys(text, "anshul")
		   		  .keyUp(Keys.SHIFT)
		   		  .build().perform();
		   		Thread.sleep(10000);
		   
	   }
}
