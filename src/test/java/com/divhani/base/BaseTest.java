package com.divhani.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // WebDriver instance - this is what controls the browser
    // Protected means all classes that extend BaseTest can access it
    protected WebDriver driver;

    // Logger instance - used to write log messages
    // LogManager.getLogger gets a logger named after this class
    protected static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        log.info("Starting test - opening Chrome browser");

        // Selenium Manager automatically handles the ChromeDriver
        // No need to set system property or download drivers manually
        driver = new ChromeDriver();

        // Maximise the browser window
        driver.manage().window().maximize();

        log.info("Browser opened and maximised successfully");
    }

    @AfterMethod
    public void tearDown() {
        log.info("Test finished - closing browser");

        // Close the browser after every test
        // Check driver is not null first to avoid errors
        if (driver != null) {
            driver.quit();
            log.info("Browser closed successfully");
        }
    }
}

