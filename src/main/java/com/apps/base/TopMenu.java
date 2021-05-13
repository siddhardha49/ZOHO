package com.apps.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apps.pages.crm.accounts.AccountsPage;

public class TopMenu {
	/*
	 * 
	 * Top Menu is a page
	 * Home has a Top Menu
	 * Accounts page has a top Menu
	 * 
	 * 
	 */
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		this.driver=driver;
	}

	public void goToHome() {

	}

	public void goToLeeds() {

	}

	public void goToContacts() {

	}

	public AccountsPage goToAccounts() {

		//Page.driver.findElement(arg0);
		
		driver.findElement(By.linkText("Accounts")).click();
		return new AccountsPage();
		
		
	}

	public void goToDeal() {

	}

	public void goToActivities() {

	}

	public void goToReports() {

	}

	public void goToAnalytics() {

	}
	
	public void signOut() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
	}

}
