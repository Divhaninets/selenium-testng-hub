package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(DynamicLoadingPage.class);

    // Locators
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By finishText = By.cssSelector("#finish h4");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToExample1() {
        // Example 1 - element hidden on page, revealed after clicking Start
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        log.info("Navigated to Dynamic Loading Example 1");
    }

    public void navigateToExample2() {
        // Example 2 - element not on page, added to DOM after clicking Start
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        log.info("Navigated to Dynamic Loading Example 2");
    }

    public void clickStart() {
        WaitUtil.waitForClickability(driver, startButton).click();
        log.info("Clicked Start button");
    }

    // Wait for loading to finish and return the text
    // This is where explicit wait is critical
    public String getFinishText() {
        // Wait for the finish element to be visible - it appears after loading
        WaitUtil.waitForVisibility(driver, finishText);
        String text = driver.findElement(finishText).getText();
        log.info("Finish text: " + text);
        return text;
    }

    public boolean isLoadingIndicatorGone() {
        // Wait for loading spinner to disappear
        try {
            WaitUtil.waitForVisibility(driver, loadingIndicator);
            return !driver.findElement(loadingIndicator).isDisplayed();
        } catch (Exception e) {
            return true; // loading is gone
        }
    }
}
