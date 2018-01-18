package com.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyElementSelect {
  WebDriver driver;
 
  @BeforeTest
  public void openBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
	   driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
  }
  @AfterTest
  public void tearDown() {
	  if (driver != null)
			driver.close();  
  }
  @Test
  public void verifyCreateAccountText() throws InterruptedException {
	  WebElement restCheckBox=driver.findElement(By.id("restapibox"));
	  boolean flag =restCheckBox.isSelected();
	  
	  System.out.println("is Rest API CheckBox Selected-"+flag);
	  
	  WebElement seleniumCheckBox =driver.findElement(By.id("seleniumbox"));
	  boolean selFlag = seleniumCheckBox.isSelected();
	  
	  System.out.println("is Selenium CheckBox selected-"+selFlag);
  }
}
