package com.apps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apps.base.Page;

public class HomePage extends Page {
	
/*	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}*/
	
	public void goToFreeSignUp() {

		driver.findElement(By.cssSelector(".zh-signup")).click();
	
		log.info("Sign up done");
	}

	public LoginPage goToSignin() {
		click("signInBtn_CSS");
		//driver.findElement(By.cssSelector(".zh-login")).click();
		log.info("Sign button clicked ");
		return new LoginPage();
	}
	
	public void goToSupport() {
		
		driver.findElement(By.cssSelector(".zh-support")).click();
		
	}

	public void goToLearnmore() {
		
	}
	public void validateFooterLink() {
		
	}
	
	
}
