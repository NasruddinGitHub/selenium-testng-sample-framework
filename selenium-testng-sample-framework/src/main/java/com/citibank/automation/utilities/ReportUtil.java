package com.citibank.automation.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil {

	private static ExtentSparkReporter extentSparkReporter;

	private static ExtentReports extentReports;

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static synchronized void initReport(String path) {
		intializeExtentSparkReport(path);
		initializeExtentReport();
		attachSparkReport();
	}

	public static synchronized ExtentSparkReporter intializeExtentSparkReport(String path) {
		return extentSparkReporter = new ExtentSparkReporter(path);
	}

	public static synchronized ExtentReports initializeExtentReport() {
		return extentReports = new ExtentReports();
	}

	public static synchronized void initializeExtentTest(String testName) {
		createTest(testName);
	}

	public static synchronized void initializeExtentTest(String testName, String description) {
		createTest(testName, description);
	}

	public static synchronized void attachSparkReport() {
		extentReports.attachReporter(extentSparkReporter);
	}

	public static synchronized ExtentSparkReporterConfig getExtentSparkReporterConfig() {
		return extentSparkReporter.config();
	}

	public static synchronized void setReportTitle(String reportTitle) {
		getExtentSparkReporterConfig().setDocumentTitle(reportTitle);
	}

	public static synchronized void setReportName(String reportName) {
		getExtentSparkReporterConfig().setReportName(reportName);
	}

	public static synchronized void setTheme(Theme theme) {
		getExtentSparkReporterConfig().setTheme(theme);
	}

	public static synchronized void setTimeStampFormat(String timeStampFormat) {
		getExtentSparkReporterConfig().setTimeStampFormat(timeStampFormat);
	}

	public static synchronized String getDocumentTitle() {
		return getExtentSparkReporterConfig().getDocumentTitle();
	}

	public static synchronized String getReportName() {
		return getExtentSparkReporterConfig().getReportName();
	}

	public static synchronized String getTimeStampFormat() {
		return getExtentSparkReporterConfig().getTimeStampFormat();
	}

	public static synchronized Theme getTheme() {
		return getExtentSparkReporterConfig().getTheme();
	}

	public static synchronized File getFile() {
		return extentSparkReporter.getFile();
	}

	public static synchronized void loadJSONConfig(File file) {
		try {
			extentSparkReporter.loadJSONConfig(file);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading json config file");
		}
	}

	public static synchronized void loadJSONConfig(String jsonString) {
		try {
			extentSparkReporter.loadJSONConfig(jsonString);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading json config file");
		}
	}

	public static synchronized void loadXMLConfig(File xmlFile) {
		try {
			extentSparkReporter.loadXMLConfig(xmlFile);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading xml config file");
		}
	}

	public static synchronized void loadXMLConfig(String xmlFile) {
		try {
			extentSparkReporter.loadXMLConfig(xmlFile);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading xml config file");
		}
	}

	public static synchronized ExtentTest getTest() {
		return extentTest.get();
	}

	public static synchronized void createTest(String name) {
		ExtentTest test = extentReports.createTest(name);
		extentTest.set(test);
	}

	public static synchronized void createTest(String name, String description) {
		ExtentTest test = extentReports.createTest(name, description);
		extentTest.set(test);
	}

	public static synchronized void flush() {
		extentReports.flush();
	}

	public static synchronized void removeTest(ExtentTest test) {
		extentReports.removeTest(test);
	}

	public static synchronized void removeTest(String name) {
		extentReports.removeTest(name);
	}

	public static synchronized void setSystemInfo(String k, String v) {
		extentReports.setSystemInfo(k, v);
	}

	public static synchronized ExtentTest assignAuthor(String... autor) {
		return getTest().assignAuthor(autor);
	}

	public static synchronized ExtentTest assignCategory(String... category) {
		return getTest().assignCategory(category);
	}

	public static synchronized ExtentTest assignDevice(String... device) {
		return getTest().assignDevice(device);
	}

	public static synchronized ExtentTest createNode(String name) {
		return getTest().createNode(name);
	}

	public static synchronized ExtentTest createNode(String name, String description) {
		return getTest().createNode(name, description);
	}

	public static synchronized ExtentTest fail(Markup markup) {
		return getTest().fail(markup);
	}

	public static synchronized ExtentTest fail(Media media) {
		return getTest().fail(media);
	}

	public static synchronized ExtentTest fail(String details) {
		return getTest().fail(details);
	}

	public static synchronized ExtentTest fail(Throwable t) {
		return getTest().fail(t);
	}

	public static synchronized ExtentTest fail(String details, Media media) {
		return getTest().fail(details, media);
	}

	public static synchronized ExtentTest fail(Throwable t, Media media) {
		return getTest().fail(t, media);
	}

	public static synchronized ExtentTest pass(Markup markup) {
		return getTest().pass(markup);
	}

	public static synchronized ExtentTest pass(Media media) {
		return getTest().pass(media);
	}

	public static synchronized ExtentTest pass(String details) {
		return getTest().pass(details);
	}

	public static synchronized ExtentTest pass(Throwable t) {
		return getTest().pass(t);
	}

	public static synchronized ExtentTest pass(String details, Media media) {
		return getTest().pass(details, media);
	}

	public static synchronized ExtentTest pass(Throwable t, Media media) {
		return getTest().pass(t, media);
	}

	public static synchronized ExtentTest info(Markup markup) {
		return getTest().info(markup);
	}

	public static synchronized ExtentTest info(Media media) {
		return getTest().info(media);
	}

	public static synchronized ExtentTest info(String details) {
		return getTest().info(details);
	}

	public static synchronized ExtentTest info(Throwable t) {
		return getTest().info(t);
	}

	public static synchronized ExtentTest info(String details, Media media) {
		return getTest().info(details, media);
	}

	public static synchronized ExtentTest info(Throwable t, Media media) {
		return getTest().info(t, media);
	}

	public static synchronized ExtentTest skip(Markup markup) {
		return getTest().skip(markup);
	}

	public static synchronized ExtentTest skip(Media media) {
		return getTest().skip(media);
	}

	public static synchronized ExtentTest skip(String details) {
		return getTest().skip(details);
	}

	public static synchronized ExtentTest skip(Throwable t) {
		return getTest().skip(t);
	}

	public static synchronized ExtentTest skip(String details, Media media) {
		return getTest().skip(details, media);
	}

	public static synchronized ExtentTest skip(Throwable t, Media media) {
		return getTest().skip(t, media);
	}

	public static synchronized ExtentTest warning(Markup markup) {
		return getTest().warning(markup);
	}

	public static synchronized ExtentTest warning(Media media) {
		return getTest().warning(media);
	}

	public static synchronized ExtentTest warning(String details) {
		return getTest().warning(details);
	}

	public static synchronized ExtentTest warning(Throwable t) {
		return getTest().warning(t);
	}

	public static synchronized ExtentTest warning(String details, Media media) {
		return getTest().warning(details, media);
	}

	public static synchronized ExtentTest warning(Throwable t, Media media) {
		return getTest().warning(t, media);
	}

	public static synchronized ExtentTest log(Status status, Media media) {
		return getTest().log(status, media);
	}

	public static synchronized ExtentTest addScreenshotAtLogLevel(Status status, String path) {
		return getTest().log(status, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	public static synchronized ExtentTest addScreenshotAtLogLevel(Status status, String path, String title) {
		return getTest().log(status, MediaEntityBuilder.createScreenCaptureFromPath(path, title).build());
	}

	public static synchronized ExtentTest addScreenCaptureFromPath(String path) {
		return getTest().addScreenCaptureFromPath(path);
	}

	public static synchronized ExtentTest addScreenCaptureFromPath(String path, String title) {
		return getTest().addScreenCaptureFromPath(path, title);
	}
}