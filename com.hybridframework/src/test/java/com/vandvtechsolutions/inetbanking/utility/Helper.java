package com.vandvtechsolutions.inetbanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String capturescreenshot(WebDriver driver) {
		String screenpath = System.getProperty("user.dir") + "//Screenshot//inetbanking_" + getCurrentDateTime() + ".png";
		
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenpath));

			System.out.println("Sccreenshot captured");
			
			return screenpath;
		} catch (Exception e) {
			System.out.println("not able to capture screenshot");
			return null;
		}

	}

	public static String getCurrentDateTime() {
		SimpleDateFormat customDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customDate.format(currentDate);
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	public static String getRandomString() {
		return RandomStringUtils.randomAlphabetic(6);
	}

	public static String getRandomNum() {
		return RandomStringUtils.randomNumeric(5);
	}

}
