package com.report;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	@BeforeTest
	public void startTest() {
	    reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//extentreport.html");
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Machine", "Akshay-PC");
		reports.setSystemInfo("Env", "Test");
		reports.setSystemInfo("Build","Integration");
		reports.setSystemInfo("Browser", "IE");
	}
	@Test
	public void passTest() {
	   test = reports.createTest("passTest");
		System.out.println("This is my Pass test");
		Assert.assertTrue(true);
		test.pass("first test passed");
	}
	@Test
	public void failTest() {
	    test = reports.createTest("failTest");
		System.out.println("This is my Fail test");
		Assert.assertTrue(false);
		test.fail("second test failed");
	}
	@Test
	public void skipTest() {
	    test = reports.createTest("skipTest");
		System.out.println("This is my Skip test");
		throw new SkipException("Skip test forcefully");
		
	}
	@AfterMethod
	public void setTestResult(ITestResult result){
	     if(result .getStatus() ==ITestResult.FAILURE){
	     test.fail(result.getName());
	     test.fail(result.getThrowable());
	  } else if(result.getStatus()== ITestResult.SUCCESS){
	      test.pass(result.getName());
	      
	}else if(result.getStatus() ==ITestResult.SKIP){
	  test.skip("Test Case: " + result.getName() + "has been skipped");
	}
	     
	}
	
    @AfterTest
    public void endTest(){
      reports.flush();
    
}
}