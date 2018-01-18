package com.selenium.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownOperations {
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
			  if (driver != null)
					driver.close(); 	   
		}
	
   @Test
    public void selectbyIndexTest() throws InterruptedException{
    	WebElement element = driver.findElement(By.id("month"));
    	Select oSelect = new Select(element);
		oSelect.selectByIndex(1);
		Thread.sleep(4000);
		
		
    }
    @Test
	public void selectbyValueTest()throws InterruptedException{
		WebElement element = driver.findElement(By.id("year"));
		Select oSelect = new Select(element);
		Thread.sleep(3000);
		oSelect.selectByValue("2007");
		Thread.sleep(3000);
	}
   @Test
    public void selectbyTextTest()throws InterruptedException{
    	WebElement element = driver.findElement(By.id("month"));
		Select oSelect = new Select(element);
		Thread.sleep(3000);
		oSelect.selectByVisibleText("Sep");	
		Thread.sleep(3000);
    }
     @Test
     public void printAllValuesTest() throws InterruptedException {
      WebElement element = driver.findElement(By.id("month"));
      Select oSelect = new Select(element);
      List<WebElement> months = oSelect.getOptions();
      System.out.println("Total Options are:" +months.size());
      for (WebElement monthValue :months){
      String value =monthValue.getText();
      System.out.println(value);
     } 
    }
}
