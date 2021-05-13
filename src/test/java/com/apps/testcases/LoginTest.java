package com.apps.testcases;

import org.testng.annotations.Test;

import com.apps.pages.HomePage;
import com.apps.pages.LoginPage;
import com.apps.pages.ZohoAppPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void doLogin() {
		HomePage home = new HomePage();
		LoginPage lp = home.goToSignin();
		ZohoAppPage zp = lp.doLogin("sotfeb2021@gmail.com", "Zoho@2021");
		
		
	}

}
