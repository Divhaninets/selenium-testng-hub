package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class InfiniteScrollPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(InfiniteScrollPage.class);

    private By paragraphs = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        log.info("Navigated to Infinite Scroll page");
    }

    public int getParagraphCount() {
        int count = driver.findElements(paragraphs).size();
        log.info("Paragraph count: " + count);
        return count;
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        log.info("Scrolled to bottom of page");
    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ")");
        log.info("Scrolled down " + pixels + " pixels");
    }
}