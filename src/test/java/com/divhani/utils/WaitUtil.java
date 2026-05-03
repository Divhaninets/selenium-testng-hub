package com.divhani.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * WAIT UTILITY
 * ============
 * Centralised explicit wait methods for the entire framework.
 *
 * Why centralise waits here?
 * - One place to change timeout values
 * - Consistent wait behaviour across all page objects
 * - No duplicate wait code in every page class
 *
 * DEFAULT_TIMEOUT = 10 seconds
 * This means Selenium will wait UP TO 10 seconds for the condition.
 * If condition is met in 2 seconds, it moves on immediately.
 */
public class WaitUtil {

    private static final Logger log = LogManager.getLogger(WaitUtil.class);
    private static final int DEFAULT_TIMEOUT = 10;

    /**
     * Waits until an element is VISIBLE on the page
     * Use for: elements that appear after page load or after an action
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        log.info("Waiting for element to be visible: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until an element is CLICKABLE
     * Use for: buttons, links - elements you need to interact with
     */
    public static WebElement waitForClickability(WebDriver driver, By locator) {
        log.info("Waiting for element to be clickable: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits until an element contains specific text
     * Use for: flash messages, success/error messages
     */
    public static boolean waitForTextToBePresent(WebDriver driver, By locator, String text) {
        log.info("Waiting for text '" + text + "' in element: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Waits until an element is PRESENT in the DOM
     * Use for: elements that exist in HTML but may not be visible yet
     */
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        log.info("Waiting for element to be present: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
