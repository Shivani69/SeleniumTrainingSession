package com.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitExample {
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
	public void selectbyIndexTest() {
		WebElement element =driver.findElement(By.id("month"));
		Select oSelect = new Select(element);
		oSelect.selectByIndex(6);
	
	try {
	Thread.sleep(5000);
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
}
}