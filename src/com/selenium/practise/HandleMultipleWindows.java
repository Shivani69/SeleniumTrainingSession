package com.selenium.practise;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HandleMultipleWindows {
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		 System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		   driver =new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   driver.get("https://www.naukri.com");
	}

	@AfterMethod
	   public void tearDown() {
			  if (driver != null)
					driver.close(); 	   
	}
	@Test
	public void multiWindowTest() {
		verifyHomeTitle();		
		
		String homeWinID = driver.getWindowHandle();
		
		WebElement  recruiterLink = driver.findElement(By.cssSelector("a[href='https://www.naukri.com/recruiters']"));
		recruiterLink.click();
		
		Set<String> allWindows =driver.getWindowHandles();
		
		Iterator<String> windowIterator =allWindows.iterator();
		while(windowIterator.hasNext()) {
			
			String recruiterWinID =windowIterator.next();
			if(!homeWinID.equals(recruiterWinID)) {
				
				driver.switchTo().window(recruiterWinID);
				
				verifyRecruiterTitle();
				
				WebElement pageHeading = driver.findElement(By.cssSelector("h1[class ='SrchHd'] span"));
				Assert.assertTrue(pageHeading.isDisplayed());
				System.out.println(pageHeading.getText());
				
				driver.close();
				
			}
			driver.switchTo().window(homeWinID);
			verifyHomeTitle();
		}	
		
	}

	public void verifyHomeTitle() {
		Assert.assertEquals(driver.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");	
		}
	
	
		public void verifyRecruiterTitle() {
		Assert.assertEquals(driver.getTitle(), "HR Manager - HR Executive - HR Recruiter Consultants - Naukri.com");
		
	}
}
