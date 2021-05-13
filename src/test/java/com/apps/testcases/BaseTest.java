package com.apps.testcases;

import org.testng.annotations.AfterSuite;

import com.apps.base.Page;

public class BaseTest {
	
	@AfterSuite
	public void tearDown() {
		
		Page.tearDown();
		System.out.println("hi");
		
	}

}
