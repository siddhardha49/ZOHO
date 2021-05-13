package com.apps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apps.base.Page;

public final class LoginPage extends Page {
	
/*	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver; 
	}*/
	
	public ZohoAppPage doLogin(String uname,String password) {
		log.info("enetered in");
		
		
		type("userName_CSS", uname);
		
		log.info("crossed login username entry");
		
		
		
		//driver.findElement(By.cssSelector("#login_id")).sendKeys(uname);
		click("nextBtn_CSS");
		
		//driver.findElement(By.cssSelector("#nextbtn")).click();
		type("password_CSS", password);
		//driver.findElement(By.cssSelector("#password")).sendKeys(password);
		click("signInNextBtn_CSS");
		//driver.findElement(By.cssSelector("#nextbtn")).click();
		//driver.findElement(By.cssSelector(".failbutton")).click();
		return new ZohoAppPage();
	}

}
