package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FloatingMenuPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(FloatingMenuPage.class);

    private By menu = By.id("menu");
    private By homeLink = By.linkText("Home");

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/floating_menu");
        log.info("Navigated to Floating Menu page");
    }

    // Scroll down the page using JavaScript
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")");
        log.info("Scrolled down " + pixels + " pixels");
    }

    // Check if menu is still displayed after scrolling
    public boolean isMenuDisplayed() {
        boolean displayed = driver.findElement(menu).isDisplayed();
        log.info("Menu displayed: " + displayed);
        return displayed;
    }

    public boolean isHomeLinkDisplayed() {
        boolean displayed = driver.findElement(homeLink).isDisplayed();
        log.info("Home link displayed: " + displayed);
        return displayed;
    }
}