package com.vandvtechsolutions.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Object Repository

	@FindBy(name = "name")
	@CacheLookup
	WebElement custnameTxt;

	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement maleRadioBtn;

	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	@CacheLookup
	WebElement femaleRadioBtn;

	@FindBy(name = "dob")
	@CacheLookup
	WebElement custdob;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement addrTxt;

	@FindBy(name = "city")
	@CacheLookup
	WebElement cityTxt;

	@FindBy(name = "state")
	@CacheLookup
	WebElement stateTxt;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement pinnoTxt;

	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement telephonenoTxt;

	@FindBy(name = "password")
	@CacheLookup
	WebElement passwordTxt;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement emailidTxt;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement subBtn;

	public void setCustomerName(String custName) {
		custnameTxt.clear();
		custnameTxt.sendKeys(custName);
	}

	public void clickOnGnderRadioBtn(String gender) {
		if (gender.equals("Male")) {
			maleRadioBtn.click();
		} else {
			femaleRadioBtn.click();
		}
	}

	public void setDob(String dob) {
		custdob.sendKeys(dob);		
	}

	public void setAddress(String address) {
		addrTxt.clear();
		addrTxt.sendKeys(address);
	}

	public void setCity(String city) {
		cityTxt.clear();
		cityTxt.sendKeys(city);
	}

	public void setState(String state) {
		stateTxt.clear();
		stateTxt.sendKeys(state);
	}

	public void setPincode(String pincode) {
		pinnoTxt.clear();
		pinnoTxt.sendKeys(pincode);

	}

	public void setTelephonenum(String telenum) {
		telephonenoTxt.clear();
		telephonenoTxt.sendKeys(telenum);

	}

	public void setPassword(String password) {
		passwordTxt.clear();
		passwordTxt.sendKeys(password);

	}

	public void setEmailId(String emailId) {
		emailidTxt.clear();
		emailidTxt.sendKeys(emailId);

	}

	public void clickOnSubmitBtn() {
		subBtn.click();

	}

}
