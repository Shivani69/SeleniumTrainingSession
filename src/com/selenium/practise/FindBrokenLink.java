package com.selenium.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.GetResponseCode;

public class FindBrokenLink {
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
		 public void getBrokenLinks() {
			
			 // Find all Elements on the page with 'a' tag
			 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			 
			 System.out.println("Total Number of Links : " +allLinks.size());
			 
			 //Iterate over all available Links on webpage
			 for (WebElement link : allLinks) {
				String linkURL = link.getAttribute("href");
				
				//Call VerifyURL form GetResponse Code Class
				GetResponseCode.verifyUrl(linkURL);
			}
			 
			 System.out.println("Total Number of Links : " +allLinks.size());
			GetResponseCode.getInvalidLinkCount(); 
		}
	
	   
   }
