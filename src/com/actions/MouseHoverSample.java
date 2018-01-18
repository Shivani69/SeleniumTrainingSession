package com.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHoverSample {
	WebDriver driver;
	   
	   @BeforeMethod
	   public void openBrowser() {
		   System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		   driver =new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   driver.get("https://www.eversource.com/content/");
}
	   @AfterMethod
	   public void tearDown() {
		   if (driver!=null)
			   driver.close();
	   }
	   @Test
	   public void performMouseHover() throws InterruptedException{
		   WebElement seleniumLink = driver.findElement(By.xpath("//*[@id='SelectButton0']"));
		   Actions act = new Actions(driver);
		   act.moveToElement(seleniumLink).perform();
		   Thread.sleep(5000);
		   
		   WebElement webdriverLink = driver.findElement(By.xpath("//*[@id='modal-footer-btn']"));
		   webdriverLink.click();
		   Thread.sleep(5000);
	   }
}
