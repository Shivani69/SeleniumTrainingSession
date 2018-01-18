package com.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableExample {
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
	public void countTotalRowsTest() {
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println("Total No of Rows:"+allRows.size()); 
		
	}
	 @Test
	public void printAllRowsTest() {
		List<WebElement> allRows =driver.findElements(By.xpath("//*[@id ='leftcontainer']/table/tbody/tr"));
		
		System.out.println("************ Starting Table **********");
		for (int row =0; row< allRows.size();row++) {
			System.out.println(allRows.get(row).getText());
		}
		System.out.println("************** Ending Table***********");
	}
 @Test
	public void countAllColsTest() {
		List<WebElement>allCols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		System.out.println("Total no of Rows: " + allCols.size());
	}
	 @Test
	public void printCompleteColumnTest() {
		List<WebElement> firstColumn =driver.findElements(By.xpath("//*[@id ='leftcontainer']/table/tbody/tr/td[4]"));
		 for( int i =0; i < firstColumn.size(); i++) {
			 System.out.println(firstColumn.get(i).getText());
	 }
}	 
	  @Test
	   public void printSpecificRowTest() {
		   WebElement row = driver.findElement(By.xpath("//*[@id ='leftcontainer']/table/tbody/tr[5]"));
		   System.out.println(row.getText());
	   }
	}
	
	
	

