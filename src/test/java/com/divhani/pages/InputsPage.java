package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputsPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(InputsPage.class);

    private By numberInput = By.cssSelector("input[type='number']");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        log.info("Navigated to Inputs page");
    }

    public void enterNumber(String number) {
        WaitUtil.waitForVisibility(driver, numberInput).clear();
        driver.findElement(numberInput).sendKeys(number);
        log.info("Entered number: " + number);
    }

    public void incrementWithArrowUp(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(numberInput).sendKeys(Keys.ARROW_UP);
        }
        log.info("Incremented input " + times + " times");
    }

    public void decrementWithArrowDown(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(numberInput).sendKeys(Keys.ARROW_DOWN);
        }
        log.info("Decremented input " + times + " times");
    }

    public String getInputValue() {
        String value = driver.findElement(numberInput).getAttribute("value");
        log.info("Input value: " + value);
        return value;
    }
}