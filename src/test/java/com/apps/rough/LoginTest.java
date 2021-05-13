package com.apps.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.apps.base.Page;
import com.apps.pages.HomePage;
import com.apps.pages.LoginPage;
import com.apps.pages.ZohoAppPage;
import com.apps.pages.crm.CRMHomePage;
import com.apps.pages.crm.accounts.AccountsPage;
import com.apps.pages.crm.accounts.CreateAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public static void main(String[] args) throws InterruptedException {

		HomePage home = new HomePage();
		LoginPage lp = home.goToSignin();
		ZohoAppPage zp = lp.doLogin("sotfeb2021@gmail.com", "Zoho@2021");
		zp.goToCRM();
		AccountsPage account=Page.topMenu.goToAccounts();		
		CreateAccountPage CreateAccountPage=account.gotoCreateAccounts();		
		CreateAccountPage.createAccount("jhon");
		Thread.sleep(5000);
		//Page.topMenu.signOut();
	}

}
