package com.javaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PageTextJs {
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
	   public void getPageTextJSTest() throws InterruptedException{
		   
		   String javaScript ="return document.documentElement.innerText;";
		   JavascriptExecutor js =(JavascriptExecutor)driver;
		   String pageText = js.executeScript(javaScript).toString();
		   System.out.println(pageText);
		   Thread.sleep(5000);
		   
	   }
	   @Test
	   public void getPageTitleJSTest() throws InterruptedException{
		   
		   String javaScript ="return document.title;";
		   JavascriptExecutor js =(JavascriptExecutor)driver;
		   String pageTitle = js.executeScript(javaScript).toString();
		   System.out.println(pageTitle);
		   
		   Assert.assertEquals(pageTitle, "Facebook - Log In or Sign Up");
		   Thread.sleep(5000);
		   
	   }
	 
}
