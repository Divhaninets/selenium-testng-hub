package com.divhani.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SCREENSHOT UTILITY
 * ==================
 * Handles taking and saving screenshots during test execution.
 *
 * Used in two ways:
 * 1. Automatically on test failure - captured by ExtentReportManager
 * 2. Manually in tests - when you want to capture a specific moment
 */
public class ScreenshotUtil {

    // Folder where screenshots will be saved
    private static final String SCREENSHOT_FOLDER = "test-output/screenshots/";

    /**
     * Takes a screenshot and saves it to the screenshots folder.
     * Returns the file path so ExtentReports can attach it to the report.
     *
     * @param driver     - the WebDriver instance
     * @param testName   - used to name the screenshot file
     * @return           - the file path of the saved screenshot
     */
    public static String takeScreenshot(WebDriver driver, String testName) {

        // Generate a timestamp so screenshots don't overwrite each other
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        String filePath = SCREENSHOT_FOLDER + fileName;

        try {
            // Cast driver to TakesScreenshot - this is the interface that allows screenshots
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Capture the screenshot as a file
            File screenshot = ts.getScreenshotAs(OutputType.FILE);

            // Copy it to our screenshots folder
            File destination = new File(filePath);
            FileUtils.copyFile(screenshot, destination);

            System.out.println("Screenshot saved: " + filePath);

        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        return filePath;
    }
}
