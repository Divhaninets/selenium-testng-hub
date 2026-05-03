package com.divhani.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * EXTENT REPORTS MANAGER
 * ======================
 * This class is a TestNG Listener.
 * A Listener "listens" to test events and reacts to them.
 *
 * Events it listens to:
 * - onStart        : test suite starts
 * - onTestSuccess  : a test passes
 * - onTestFailure  : a test fails
 * - onTestSkipped  : a test is skipped
 * - onFinish       : test suite finishes - this is where we generate the report
 */
public class ExtentReportManager implements ITestListener {

    // ExtentReports - the main report object
    private ExtentReports extent;

    // ExtentTest - represents one individual test in the report
    private ExtentTest test;

    // Where the report HTML file will be saved
    private static final String REPORT_PATH = "test-output/ExtentReport.html";

    @Override
    public void onStart(ITestContext context) {
        // Called once when the test suite starts
        // This is where we set up the report configuration

        // SparkReporter creates the actual HTML file
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);

        // Configure the report appearance
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Selenium TestNG Hub - Test Report");
        sparkReporter.config().setReportName("Automation Test Results");

        // Attach the spark reporter to extent
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system information to the report
        extent.setSystemInfo("Project", "Selenium TestNG Hub");
        extent.setSystemInfo("Tester", "Divhani");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Called before each test method runs
        // Creates a new test entry in the report
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Called when a test passes
        test.pass("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Called when a test fails
        // Get the driver from the failed test class
        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            // Access the driver field from BaseTest
            java.lang.reflect.Field field = testClass.getClass()
                    .getSuperclass()
                    .getDeclaredField("driver");
            field.setAccessible(true);
            driver = (WebDriver) field.get(testClass);
        } catch (Exception e) {
            test.fail("Could not get driver for screenshot: " + e.getMessage());
        }

        // Take screenshot and attach to report
        if (driver != null) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver,
                    result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath,
                    "Screenshot on failure");
        }

        // Log the failure
        test.fail("Test failed: " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Called when a test is skipped
        test.skip("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Called once when all tests finish
        // This flushes and saves the HTML report to disk
        extent.flush();
    }
}
