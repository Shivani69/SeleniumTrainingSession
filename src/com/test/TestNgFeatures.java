package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {
  @Test
  public void LoginTest() {
	  System.out.println("LoginTest");
	  //int i =9/0;
  }
  @Test(dependsOnMethods="LoginTest")
  public void HomepageTest() {
	  System.out.println("HomePageTest");
  }
@Test(dependsOnMethods="LoginTest")
public void SearchPageTest() {
	  System.out.println("SearchPageTest");
  }
	@Test(dependsOnMethods="LoginTest")
	public void RegPageTest() {
	  System.out.println("RegPage Test");
  }
}
