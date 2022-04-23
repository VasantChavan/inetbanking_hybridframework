package com.vandvtechsolutions.inetbanking.testcasess;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vandvtechsolutions.inetbanking.pageobjects.AddNewCustomerPage;
import com.vandvtechsolutions.inetbanking.pageobjects.HomePage;
import com.vandvtechsolutions.inetbanking.pageobjects.LoginPage;
import com.vandvtechsolutions.inetbanking.testbase.TestBase;
import com.vandvtechsolutions.inetbanking.utility.Helper;

public class AddNewCustomerTC_001 extends TestBase {

	
	
	@Test
	public void adNewCustomerTest() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.setUsername(configDataProvider.getUserName());
		login.setPassword(configDataProvider.getPwrd());
		HomePage homepage = login.clickOnLoginBtn();

		Thread.sleep(3000);

		AddNewCustomerPage addCust = homepage.clickonNewCustomerLink();

		addCust.setCustomerName("abcd");
		addCust.clickOnGnderRadioBtn("Male");

		addCust.setDob("12");
		Thread.sleep(2000);

		addCust.setDob("05");
		Thread.sleep(2000);
		addCust.setDob("2021");

		addCust.setAddress("Mastodhari Colony");
		addCust.setCity("Ambad");

		addCust.setState("Maharasshtra");
		addCust.setPincode("431204");

		addCust.setTelephonenum("9876543210");
		
		String randomstring =Helper.getRandomString();
		
		addCust.setEmailId(randomstring+"@gmail.com");

		addCust.setPassword("abcd@223$");

		addCust.clickOnSubmitBtn();
		
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
