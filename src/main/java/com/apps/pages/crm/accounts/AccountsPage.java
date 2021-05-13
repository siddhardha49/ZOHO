package com.apps.pages.crm.accounts;

import org.openqa.selenium.By;

import com.apps.base.Page;

public class AccountsPage extends Page {
	
	
	public CreateAccountPage gotoCreateAccounts() {
		click("goToCreateAccounts_XPATH");
		//driver.findElement(By.xpath("//*[@id=\"table_row_1\"]/lyte-td[3]/span[1]/link-to")).click();
		return new CreateAccountPage();
	}
	
	public void gotoImportAccounts() {
		
	}

}
