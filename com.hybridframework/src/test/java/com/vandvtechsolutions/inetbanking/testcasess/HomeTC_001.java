package com.vandvtechsolutions.inetbanking.testcasess;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vandvtechsolutions.inetbanking.pageobjects.HomePage;
import com.vandvtechsolutions.inetbanking.pageobjects.LoginPage;
import com.vandvtechsolutions.inetbanking.testbase.TestBase;

public class HomeTC_001 extends TestBase {

	HomePage homepage;

	@Test(priority = 1)
	public void verifyLoginFunctionality() {

		LoginPage login = new LoginPage(driver);
		login.setUsername(configDataProvider.getUserName());
		login.setPassword(configDataProvider.getPwrd());
		homepage = login.clickOnLoginBtn();
	}

	@Test(priority = 2, enabled = false)
	public void navigateToEditCutomerPage() {
		homepage.clickOnEditCutomerLink();
	}

	@Test(priority = 3)
	public void verifyLogoutFunctionality() {
		homepage.clickOnLogoutLink();

		if (driver.getTitle().equals("Guru99 Bank Home Page")) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
