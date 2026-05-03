package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(ShadowDomPage.class);

    private By shadowHost = By.cssSelector("my-paragraph");

    public ShadowDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/shadowdom");
        log.info("Navigated to Shadow DOM page");
    }

    // Access Shadow DOM using JavaScript
    // Shadow DOM elements are hidden inside a shadow root
    // Regular findElement cannot reach them
    public String getShadowDomText() {
        try {
            WebElement shadowHostElement = driver.findElement(shadowHost);
            // Selenium 4 - use getShadowRoot() directly
            SearchContext shadowRoot = shadowHostElement.getShadowRoot();
            WebElement shadowContent = shadowRoot.findElement(By.cssSelector("p"));
            String text = shadowContent.getText();
            log.info("Shadow DOM text: " + text);
            return text;
        } catch (Exception e) {
            log.warn("Shadow DOM access failed: " + e.getMessage());
            return "";
        }
    }

    public boolean pageLoaded() {
        return driver.getCurrentUrl().contains("shadowdom");
    }
}