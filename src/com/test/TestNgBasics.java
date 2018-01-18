package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	// Pre condition annotations starting @before
	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite---setup system property for chrome");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest---Launch chrome Browser");
		
	}
	@BeforeClass
	public void login() {
		System.out.println("@BeforeClass----Login to app");
	}
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("@BeforeMethod----Enter URL");
	}
	
	//testcase  -- starting with @test
	@Test
	public void googleTitleTest() {
		System.out.println("@Test---Google Title Test");
	}
    @Test
    public void searchTest() {
    	System.out.println("@Test---search test");
    }
	@Test
	public void googlelogoTest() {
		System.out.println("@Test---Google logo Test");
	}
	//post condition annotations starting @after
	
	@AfterMethod
    public void logout() {
    	System.out.println("@AfterMethod---Logout from app");
    }
    @AfterTest
    public void deleteallCookies() {
    	System.out.println("@AfterTest---Delete all Cookies");
    }
    @AfterClass
    public void closeBrowser() {
    	System.out.println("@AfterClass---Close Browser");
    }
   
}
