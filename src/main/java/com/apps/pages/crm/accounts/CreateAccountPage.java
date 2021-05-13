package com.apps.pages.crm.accounts;

import org.openqa.selenium.By;

import com.apps.base.Page;

public class CreateAccountPage extends Page {
	
	public void createAccount(String name) throws InterruptedException {
		
		
		type("createAccountName_ID", name);
		//driver.findElement(By.id("Crm_Accounts_ACCOUNTNAME")).sendKeys(name);
		
	}

}
