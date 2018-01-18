package com.javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementViewUsingJS {
	WebDriver driver;
	   
	   @BeforeMethod
	   public void openBrowser() {
		   System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		   driver =new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose"); 
		   
}
	   @AfterMethod
	   public void tearDown() {
		   if (driver!=null)
			   driver.close();
	   }
	  @Test
	   public void scrollToElementTest() throws InterruptedException{
		  WebElement myPortfolio = driver.findElement(By.xpath("//*[@id='allpage_links']/tbody/tr[2]/td[4]/a[1]"));
		  Thread.sleep(3000);
		  
		  String javaScript ="arguments[0].scrollIntoView(true);";
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript(javaScript, myPortfolio);
		  Thread.sleep(3000);
   }
	  
	@Test
	public void reloadBrowserTEst() throws InterruptedException{
		Thread.sleep(3000);
		String javaScript ="history.go(0);";
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(javaScript);
		
		Thread.sleep(3000);
	}
	@Test
	public void navigateToURLTest() throws InterruptedException{
		
		String javaScript ="window.location ='https://www.facebook.com/easybix';";
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(javaScript);
		
		Thread.sleep(3000);
	}
	@Test
	public void scrollPageTest() throws InterruptedException{
		
		Thread.sleep(3000);
		String javaScript ="window.scrollBy(0,2500);";
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(javaScript);
		
		Thread.sleep(3000);
	}
}
