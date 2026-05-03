package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbTestPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(AbTestPage.class);

    private By heading = By.tagName("h3");

    public AbTestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/abtest");
        log.info("Navigated to A/B Test page");
    }

    public String getHeadingText() {
        String text = driver.findElement(heading).getText();
        log.info("Heading text: " + text);
        return text;
    }
}
