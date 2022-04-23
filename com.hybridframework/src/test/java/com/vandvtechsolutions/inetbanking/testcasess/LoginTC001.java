package com.vandvtechsolutions.inetbanking.testcasess;

import org.testng.annotations.Test;

import com.vandvtechsolutions.inetbanking.pageobjects.LoginPage;
import com.vandvtechsolutions.inetbanking.testbase.TestBase;

public class LoginTC001 extends TestBase {

//	@Test
//	public void verifyLoginFunctionalityTC001() {
//
//		LoginPage login = new LoginPage(driver);
//		login.setUsername("mngr395244");
//		login.setPassword("YrYbEjY");
//		login.clickOnLoginBtn();
//	}
	
	@Test
	public void verifyLoginFunctionalityTC001() {

		extentTest =extentReport.createTest("Login Functionality Test");
		LoginPage login = new LoginPage(driver);
		login.setUsername(configDataProvider.getUserName());
		login.setPassword(configDataProvider.getPwrd());
		login.clickOnLoginBtn();
	}

}
