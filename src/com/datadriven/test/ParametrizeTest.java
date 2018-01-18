package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParametrizeTest {

	public static void main(String[] args) {
		
		//webdriver code:
		System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		//get data from excel
		
		Xls_Reader reader = new Xls_Reader("C://tools//projects//workspace//JavaTraining//SeleniumTrainingSession//src//com//testdata//HalfEbayTestData.xlsx");
		int rowCount= reader.getRowCount("RegTestData");
		reader.addColumn("RegTestData", "Status");
		
		//data driven approach- used to create the data driven framework.--driving the data from excel/.csv files or any other file
		
		//parameterization
		for(int rowNum =2; rowNum<=rowCount; rowNum++) {
			System.out.println("******");
			String firstName =reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstName);
			
			String lastName =reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastName);
			
			String address1 =reader.getCellData("RegTestData", "address1", rowNum);
			System.out.println(address1);
			
			String address2 =reader.getCellData("RegTestData", "address2", rowNum);
			System.out.println(address2);
			
			String city =reader.getCellData("RegTestData", "city", rowNum);
			System.out.println(city);
			
			String state =reader.getCellData("RegTestData", "state", rowNum);
			System.out.println(state);
			
			String zipCode =reader.getCellData("RegTestData", "zipcode", rowNum);
			System.out.println(zipCode);
			
			String emailAddress =reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(emailAddress);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
			
			driver.findElement(By.xpath("//*[@id='lastname']")).clear();
			driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);
			
			driver.findElement(By.xpath("//*[@id='address1']")).clear();
			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
			
			driver.findElement(By.xpath("//*[@id='address2']")).clear();
			driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
			
			driver.findElement(By.xpath("//*[@id='city']")).clear();
			driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
			
			Select select = new Select(driver.findElement(By.xpath("//*[@id='state']")));
			select.selectByVisibleText(state);
			
			driver.findElement(By.xpath("//*[@id='zip']")).clear();
			driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipCode);
			
			driver.findElement(By.xpath("//*[@id='email']")).clear();
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailAddress);
			
			driver.findElement(By.xpath("//*[@id='retype_email']")).clear();
			driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailAddress);
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");//write the data into the cell
		   }
		}
	}

