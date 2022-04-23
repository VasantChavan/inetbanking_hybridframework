package com.vandvtechsolutions.inetbanking.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vandvtechsolutions.inetbanking.utility.Helper;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// OR HomePage Layer
	@FindBy(linkText = "New Customer")
	WebElement newCustomerLink;

	@FindBy(linkText = "Edit Customer")
	WebElement editCustomer_Link;

	@FindBy(linkText = "Delete Customer")
	WebElement deleteCustomer_Link;

	@FindBy(linkText = "New Account")
	WebElement newAccount_Link;

	@FindBy(linkText = "Log out")
	WebElement logout_Link;

	public AddNewCustomerPage clickonNewCustomerLink() {
		try {
			newCustomerLink.click();
			return new AddNewCustomerPage(driver);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public NewAccountPage clickonNewAccountLink() {
		try {
			newAccount_Link.click();
			return new NewAccountPage();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public EditCutomerPage clickOnEditCutomerLink() {
		try {
			editCustomer_Link.click();
			return new EditCutomerPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void clickOnLogoutLink() {
		try {
			logout_Link.click();
			if(Helper.isAlertPresent(driver)) {
				Alert alert =driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
