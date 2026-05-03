package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(KeyPressesPage.class);

    // Locators
    private By keyInput = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        log.info("Navigated to Key Presses page");
    }

    // Press a single key
    public void pressKey(Keys key) {
        WaitUtil.waitForVisibility(driver, keyInput).sendKeys(key);
        log.info("Pressed key: " + key.name());
    }

    // Press Enter key — commonly used to submit forms
    public void pressEnter() {
        WaitUtil.waitForVisibility(driver, keyInput).sendKeys(Keys.ENTER);
        log.info("Pressed ENTER key");
    }

    // Press Tab key — moves focus to next element
    public void pressTab() {
        WaitUtil.waitForVisibility(driver, keyInput).sendKeys(Keys.TAB);
        log.info("Pressed TAB key");
    }

    // Press Escape key
    public void pressEscape() {
        WaitUtil.waitForVisibility(driver, keyInput).sendKeys(Keys.ESCAPE);
        log.info("Pressed ESCAPE key");
    }

    // Press arrow keys
    public void pressArrowDown() {
        WaitUtil.waitForVisibility(driver, keyInput).sendKeys(Keys.ARROW_DOWN);
        log.info("Pressed ARROW DOWN key");
    }

    // Get the result text showing which key was pressed
    public String getResultText() {
        WaitUtil.waitForVisibility(driver, resultText);
        String text = driver.findElement(resultText).getText();
        log.info("Result text: " + text);
        return text;
    }
}
