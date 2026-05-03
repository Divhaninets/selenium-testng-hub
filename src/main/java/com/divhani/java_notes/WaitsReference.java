package com.divhani.java_notes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

/**
 * WAITS REFERENCE GUIDE
 * =====================
 * This class is NOT a test class.
 * It is a REFERENCE LIBRARY for all wait types in Selenium.
 *
 * The 3 wait types:
 * 1. Implicit Wait
 * 2. Explicit Wait
 * 3. Fluent Wait
 *
 * GOLDEN RULE: Never mix implicit and explicit waits.
 * They can cause unpredictable behaviour together.
 */
public class WaitsReference {

    WebDriver driver;

    // =====================================================================
    // 1. IMPLICIT WAIT
    // =====================================================================
    // Set ONCE and applies to EVERY findElement call globally
    // Tells Selenium: wait up to X seconds before throwing NoSuchElementException
    // Set in BaseTest setUp() method

    public void implicitWaitExample() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Now every findElement will wait up to 10 seconds before failing
        // Simple but not flexible - same timeout for everything
    }

    // WHEN TO USE: Simple projects, quick scripts
    // WHEN NOT TO USE: Professional frameworks - use explicit wait instead
    // WHY NOT: Cannot wait for specific conditions, just element presence

    // =====================================================================
    // 2. EXPLICIT WAIT
    // =====================================================================
    // Waits for a SPECIFIC CONDITION on a SPECIFIC ELEMENT
    // Most powerful and most used in professional frameworks

    public void explicitWaitExample() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until element is VISIBLE
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );

        // Wait until element is CLICKABLE
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit"))
        );

        // Wait until element CONTAINS text
        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.id("flash"), "success"
                )
        );

        // Wait until element is PRESENT in DOM (but may not be visible)
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("hidden"))
        );

        // Wait until element DISAPPEARS
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.id("loading"))
        );

        // Wait until URL contains a string
        wait.until(
                ExpectedConditions.urlContains("dashboard")
        );

        // Wait until title contains a string
        wait.until(
                ExpectedConditions.titleContains("Home")
        );
    }

    // WHEN TO USE: Always — this is the professional standard
    // WHY: Waits for exact conditions, different timeouts per element

    // =====================================================================
    // 3. FLUENT WAIT
    // =====================================================================
    // Like explicit wait but with extra control:
    // - Set how OFTEN it checks (polling interval)
    // - Set which EXCEPTIONS to ignore while waiting

    public void fluentWaitExample() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))      // max wait time
                .pollingEvery(Duration.ofSeconds(2))       // check every 2 seconds
                .ignoring(NoSuchElementException.class);   // ignore this exception while waiting

        WebElement element = wait.until(driver ->
                driver.findElement(By.id("dynamicElement"))
        );
    }

    // WHEN TO USE: Elements that appear unpredictably or after long delays
    // EXAMPLE: File processing, API callbacks, slow third-party widgets

    // =====================================================================
    // COMPARISON TABLE
    // =====================================================================
    // | Type     | Scope    | Condition | Polling | Use Case              |
    // | Implicit | Global   | Presence  | Default | Simple projects       |
    // | Explicit | Per call | Any       | Default | Professional standard |
    // | Fluent   | Per call | Any       | Custom  | Slow/unpredictable    |

    // =====================================================================
    // COMMON EXPECTEDCONDITIONS — INTERVIEW MUST KNOWS
    // =====================================================================
    // visibilityOfElementLocated     — element visible on screen
    // elementToBeClickable           — element visible AND enabled
    // presenceOfElementLocated       — element in DOM, may not be visible
    // invisibilityOfElementLocated   — element gone or hidden
    // textToBePresentInElementLocated — element contains specific text
    // alertIsPresent                 — browser alert is showing
    // frameToBeAvailableAndSwitchToIt — frame ready to switch into
    // urlContains                    — URL contains a string
    // titleContains                  — page title contains a string
    // numberOfElementsToBe           — exact count of elements
    // stalenessOf                    — element removed from DOM
}