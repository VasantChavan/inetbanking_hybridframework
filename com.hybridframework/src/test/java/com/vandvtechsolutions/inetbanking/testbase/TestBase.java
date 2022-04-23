package com.vandvtechsolutions.inetbanking.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vandvtechsolutions.inetbanking.utility.ConfigDataProvider;
import com.vandvtechsolutions.inetbanking.utility.ExcelDataProvider;
import com.vandvtechsolutions.inetbanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	static String configdatapath = "./Config/config.properties";
	static String excelDataProviderpath = "./TestData/Data.xlsx";

	public ConfigDataProvider configDataProvider;
	public ExcelDataProvider excelDataProvider;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@BeforeSuite
	public void init() {
		configDataProvider = new ConfigDataProvider(configdatapath);
		excelDataProvider = new ExcelDataProvider(excelDataProviderpath);

		String extentReporterPath = System.getProperty("user.dir") + "//Reports//inetbanking_report_"
				+ Helper.getCurrentDateTime() + ".html";

		htmlReporter = new ExtentHtmlReporter(extentReporterPath);

		htmlReporter.config().setDocumentTitle("Automation Test Reports");
		htmlReporter.config().setReportName("Functiona Test Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);

		extentReport.setSystemInfo("Hostname", "Local Host");
		extentReport.setSystemInfo("OS", "Windows10");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Environment", "Regression");
		extentReport.setSystemInfo("Tester Name", "Vasant");

	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(@Optional("Chrome") String brName) {

		if (brName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (brName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser not matched please chewck with expected browser");
		}

		driver.manage().window().maximize();
		driver.get(configDataProvider.getURL());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail("Test Case Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test Case Skipped ");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test Case Pass ");
		}
		driver.quit();

	}

	@AfterTest
	public void flushReport() {
		extentReport.flush();
		driver.quit();

	}

//	Access details to demo site.
//	User ID :	mngr395244
//	Password :	YrYbEjY
//	This access is valid only for 20 days.
}
