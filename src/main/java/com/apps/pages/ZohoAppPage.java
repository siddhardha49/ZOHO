package com.apps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apps.base.Page;
import com.apps.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
	
	/*WebDriver driver;
	
	public ZohoAppPage(WebDriver driver) {
		this.driver=driver;
		
	}*/
	
	public CRMHomePage goToCRM() {
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[6]/div/a/div")).click();
		return new CRMHomePage();
	}
	public void goToCampagins() {
		
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[3]/div/a/div")).click();
	}

	public void goToDesk() {
		
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[3]/div/a/div")).click();
		
		
	}


}
