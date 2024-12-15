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

	private static ExtentTest extentTest;

	public static void initReport(String path) {
		intializeExtentSparkReport(path);
		initializeExtentReport();
		attachSparkReport();
	}

	public static ExtentSparkReporter intializeExtentSparkReport(String path) {
		return extentSparkReporter = new ExtentSparkReporter(path);
	}

	public static ExtentReports initializeExtentReport() {
		return extentReports = new ExtentReports();
	}

	public static ExtentTest initializeExtentTest(String testName) {
		return createTest(testName);
	}

	public static ExtentTest initializeExtentTest(String testName, String description) {
		return createTest(testName, description);
	}

	public static void attachSparkReport() {
		extentReports.attachReporter(extentSparkReporter);
	}

	public static ExtentSparkReporterConfig getExtentSparkReporterConfig() {
		return extentSparkReporter.config();
	}

	public static void setReportTitle(String reportTitle) {
		getExtentSparkReporterConfig().setDocumentTitle(reportTitle);
	}

	public static void setReportName(String reportName) {
		getExtentSparkReporterConfig().setReportName(reportName);
	}

	public static void setTheme(Theme theme) {
		getExtentSparkReporterConfig().setTheme(theme);
	}

	public static void setTimeStampFormat(String timeStampFormat) {
		getExtentSparkReporterConfig().setTimeStampFormat(timeStampFormat);
	}

	public static String getDocumentTitle() {
		return getExtentSparkReporterConfig().getDocumentTitle();
	}

	public static String getReportName() {
		return getExtentSparkReporterConfig().getReportName();
	}

	public static String getTimeStampFormat() {
		return getExtentSparkReporterConfig().getTimeStampFormat();
	}

	public static Theme getTheme() {
		return getExtentSparkReporterConfig().getTheme();
	}

	public static File getFile() {
		return extentSparkReporter.getFile();
	}

	public static void loadJSONConfig(File file) {
		try {
			extentSparkReporter.loadJSONConfig(file);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading json config file");
		}
	}

	public static void loadJSONConfig(String jsonString) {
		try {
			extentSparkReporter.loadJSONConfig(jsonString);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading json config file");
		}
	}

	public static void loadXMLConfig(File xmlFile) {
		try {
			extentSparkReporter.loadXMLConfig(xmlFile);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading xml config file");
		}
	}

	public static void loadXMLConfig(String xmlFile) {
		try {
			extentSparkReporter.loadXMLConfig(xmlFile);
		} catch (IOException e) {
			System.out.println("Exception is thrown when loading xml config file");
		}
	}

	public static ExtentTest createTest(String name) {
		extentTest = extentReports.createTest(name);
		return extentTest;
	}

	public static ExtentTest createTest(String name, String description) {
		extentTest = extentReports.createTest(name, description);
		return extentTest;
	}

	public static void flush() {
		extentReports.flush();
	}

	public static void removeTest(ExtentTest test) {
		extentReports.removeTest(test);
	}

	public static void removeTest(String name) {
		extentReports.removeTest(name);
	}

	public static void setSystemInfo(String k, String v) {
		extentReports.setSystemInfo(k, v);
	}

	public static ExtentTest assignAuthor(String... autor) {
		return extentTest.assignAuthor(autor);
	}

	public static ExtentTest assignCategory(String... category) {
		return extentTest.assignCategory(category);
	}

	public static ExtentTest assignDevice(String... device) {
		return extentTest.assignDevice(device);
	}

	public static ExtentTest createNode(String name) {
		return extentTest.createNode(name);
	}

	public static ExtentTest createNode(String name, String description) {
		return extentTest.createNode(name, description);
	}

	public static ExtentTest fail(Markup markup) {
		return extentTest.fail(markup);
	}

	public static ExtentTest fail(Media media) {
		return extentTest.fail(media);
	}

	public static ExtentTest fail(String details) {
		return extentTest.fail(details);
	}

	public static ExtentTest fail(Throwable t) {
		return extentTest.fail(t);
	}

	public static ExtentTest fail(String details, Media media) {
		return extentTest.fail(details, media);
	}

	public static ExtentTest fail(Throwable t, Media media) {
		return extentTest.fail(t, media);
	}

	public static ExtentTest pass(Markup markup) {
		return extentTest.pass(markup);
	}

	public static ExtentTest pass(Media media) {
		return extentTest.pass(media);
	}

	public static ExtentTest pass(String details) {
		return extentTest.pass(details);
	}

	public static ExtentTest pass(Throwable t) {
		return extentTest.pass(t);
	}

	public static ExtentTest pass(String details, Media media) {
		return extentTest.pass(details, media);
	}

	public static ExtentTest pass(Throwable t, Media media) {
		return extentTest.pass(t, media);
	}

	public static ExtentTest info(Markup markup) {
		return extentTest.info(markup);
	}

	public static ExtentTest info(Media media) {
		return extentTest.info(media);
	}

	public static ExtentTest info(String details) {
		return extentTest.info(details);
	}

	public static ExtentTest info(Throwable t) {
		return extentTest.info(t);
	}

	public static ExtentTest info(String details, Media media) {
		return extentTest.info(details, media);
	}

	public static ExtentTest info(Throwable t, Media media) {
		return extentTest.info(t, media);
	}

	public static ExtentTest skip(Markup markup) {
		return extentTest.skip(markup);
	}

	public static ExtentTest skip(Media media) {
		return extentTest.skip(media);
	}

	public static ExtentTest skip(String details) {
		return extentTest.skip(details);
	}

	public static ExtentTest skip(Throwable t) {
		return extentTest.skip(t);
	}

	public static ExtentTest skip(String details, Media media) {
		return extentTest.skip(details, media);
	}

	public static ExtentTest skip(Throwable t, Media media) {
		return extentTest.skip(t, media);
	}

	public static ExtentTest warning(Markup markup) {
		return extentTest.warning(markup);
	}

	public static ExtentTest warning(Media media) {
		return extentTest.warning(media);
	}

	public static ExtentTest warning(String details) {
		return extentTest.warning(details);
	}

	public static ExtentTest warning(Throwable t) {
		return extentTest.warning(t);
	}

	public static ExtentTest warning(String details, Media media) {
		return extentTest.warning(details, media);
	}

	public static ExtentTest warning(Throwable t, Media media) {
		return extentTest.warning(t, media);
	}

	public static ExtentTest log(Status status, Media media) {
		return extentTest.log(status, media);
	}

	public static ExtentTest addScreenshotAtLogLevel(Status status, String path) {
		return extentTest.log(status, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	public static ExtentTest addScreenshotAtLogLevel(Status status, String path, String title) {
		return extentTest.log(status, MediaEntityBuilder.createScreenCaptureFromPath(path, title).build());
	}

	public static ExtentTest addScreenCaptureFromPath(String path) {
		return extentTest.addScreenCaptureFromPath(path);
	}

	public static ExtentTest addScreenCaptureFromPath(String path, String title) {
		return extentTest.addScreenCaptureFromPath(path, title);
	}
}