package com.vandvtechsolutions.inetbanking.testcasess;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vandvtechsolutions.inetbanking.pageobjects.LoginPage;
import com.vandvtechsolutions.inetbanking.testbase.TestBase;

public class LoginTC002 extends TestBase {
	
	
	@DataProvider
	public Object[][] getData() {
		
		return excelDataProvider.getExcelTestData("DTT_login");
	}
	
	@Test(dataProvider="getData")
	public void verifyLoginFunctionalityDDTest(Object username, Object password)
	{
		LoginPage login = new LoginPage(driver);
		login.setUsername((String)username);
		login.setPassword((String)password);
		
		login.clickOnLoginBtn();
	}
	
	/*
	 * 
	 * @Test public void verifyLoginFunctionalityTC001() {
	 * 
	 * LoginPage login = new LoginPage(driver);
	 * 
	 * login.setUsername(excelDataProvider.getStringCellValue("login", 1, 0));
	 * login.setPassword(excelDataProvider.getStringCellValue("login", 1, 1));
	 * 
	 * login.clickOnLoginBtn(); }
	 */
	
	
	
}
