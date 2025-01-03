package com.citibank.automation.testclasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.citibank.automation.constants.Browser;
import com.citibank.automation.constants.Property;
import com.citibank.automation.helpers.ConfigManager;
import com.citibank.automation.utilities.ReportUtil;
import com.citibank.automation.utilities.TimeUtil;
import com.google.common.io.Files;

public class BaseTest {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private static final String TEST_EXECUTION_REPORTS_PATH = "C:\\Users\\Headway\\git\\selenium-testng-sample-framework\\selenium-testng-sample-framework\\test-execution-reports\\TestReport"
			+ TimeUtil.getTimeStamp() + ".html";
	private String screenshotFolder = "C:\\Users\\Headway\\eclipse-workspace\\automate-citibank\\test-execution-reports\\screenshots";
	private String timeStamp;

	@BeforeSuite
	public void initializeReports() {
		ReportUtil.initReport(TEST_EXECUTION_REPORTS_PATH);
		ReportUtil.setReportName("Smoke Tests Execution Report");
		ReportUtil.setReportTitle("Swag Labs Test Execution Report");
		ReportUtil.setTheme(Theme.DARK);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}

	@Parameters(value = { "browser" })
	@BeforeMethod
	public void invokeBrowser(@Optional String browser) {
		if (browser == "" || browser == null) {
			browser = ConfigManager.getInstance().getProperty(Property.BROWSER);
		}
		switch (browser.toLowerCase()) {
		case Browser.CHROME:
			ChromeOptions co = new ChromeOptions();
			String[] chromeOptionArguments = ConfigManager.getInstance().getProperty(Property.CHROME_OPTION_ARGUMENTS).split(",");
			co.addArguments(chromeOptionArguments);
			driver.set(new ChromeDriver(co));
			break;
		case Browser.FIREFOX:
			FirefoxOptions fo = new FirefoxOptions();
			String[] firefoxOptionArguments = ConfigManager.getInstance().getProperty(Property.FIREFOX_OPTION_ARGUMENTS).split(",");
			fo.addArguments(firefoxOptionArguments);
			driver.set(new FirefoxDriver(fo));
			break;
		case Browser.EDGE:
			EdgeOptions eo = new EdgeOptions();
			String[] edgeOptionArguments = ConfigManager.getInstance().getProperty(Property.EDGE_OPTION_ARGUMENTS).split(",");
			eo.addArguments(edgeOptionArguments);
			driver.set(new EdgeDriver(eo));
			break;
		default:
			throw new IllegalArgumentException("Given browser is invalid: " + browser);
		}
		String url = ConfigManager.getInstance().getProperty(Property.URL);
		getDriver().get(url);

	}

	@AfterMethod
	public void saveScreenshot(ITestResult testResult) throws IOException {
		boolean screenshotForFailedTests = Boolean.parseBoolean(ConfigManager.getInstance().getProperty(Property.SCREENSHOT_FOR_FAILED_TESTS));
		boolean screenshotForPassedTests = Boolean.parseBoolean(ConfigManager.getInstance().getProperty(Property.SCREENSHOT_FOR_PASSED_TESTS));
		timeStamp = TimeUtil.getTimeStamp();
		String screenshotName = "Screenshot" + timeStamp + ".png";
		String screenshotPath = Paths.get(screenshotFolder, screenshotName).toString();
		if (screenshotForFailedTests) {
			if (!testResult.isSuccess()) {
				getScreenshot(screenshotPath);
			}
		}

		if (screenshotForPassedTests) {
			if (testResult.isSuccess()) {
				getScreenshot(screenshotPath);
			}
		}
	}

	@AfterMethod
	public void saveScreenshotToReport(ITestResult testResult) throws IOException {
		boolean attachScreenshotForFailedTests = Boolean
				.parseBoolean(ConfigManager.getInstance().getProperty(Property.ATTACH_FAILED_SCREENSHOT_IN_REPORT));
		boolean attachScreenshotForPassedTests = Boolean
				.parseBoolean(ConfigManager.getInstance().getProperty(Property.ATTACH_PASSED_SCREENSHOT_IN_REPORT));
		String screenshotName = "Screenshot" + timeStamp + ".png";
		String screenshotPath = Paths.get(screenshotFolder, screenshotName).toString();
		if (attachScreenshotForFailedTests) {
			if (!testResult.isSuccess()) {
				ReportUtil.addScreenCaptureFromPath(screenshotPath);
			}
		}

		if (attachScreenshotForPassedTests) {
			if (testResult.isSuccess()) {
				ReportUtil.addScreenCaptureFromPath(screenshotPath);
			}
		}
	}

	@AfterMethod
	public void saveTestResultToReport(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			ReportUtil.fail("Test Case is failed.");
		}
		if (testResult.isSuccess()) {
			ReportUtil.pass("Test Case is passed.");
		}
	}

	@AfterMethod
	public void tearDownBrowser() {
		getDriver().quit();
		ReportUtil.info("Browser is closed");
	}

	@AfterSuite
	public void flushReport() {
		ReportUtil.flush();
	}

	public void getScreenshot(String path) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File(path));
	}
}
