package com.divhani.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // WebDriver instance - this is what controls the browser
    // Protected means all classes that extend BaseTest can access it
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Selenium Manager automatically handles the ChromeDriver
        // No need to set system property or download drivers manually
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after every test
        // Check driver is not null first to avoid errors
        if (driver != null) {
            driver.quit();
        }
    }
}
