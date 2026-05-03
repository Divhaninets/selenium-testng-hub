package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(FramesPage.class);

    // iFrame locator
    private By iFrame = By.id("mce_0_ifr");
    private By frameBody = By.tagName("body");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToIFrame() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        log.info("Navigated to iFrame page");
    }

    public void navigateToNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        log.info("Navigated to Nested Frames page");
    }

    // Switch INTO the iFrame
    public void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(iFrame));
        log.info("Switched into iFrame");
    }

    // Switch back to main page
    public void switchToMainPage() {
        driver.switchTo().defaultContent();
        log.info("Switched back to main page");
    }

    // Get text from inside the iFrame body
    public String getIFrameBodyText() {
        String text = driver.findElement(frameBody).getText();
        log.info("iFrame body text: " + text);
        return text;
    }

    // Switch into frames by index - most reliable for nested frames
    public void switchToFrameByIndex(int index) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(index);
        log.info("Switched to frame at index: " + index);
    }

    public String getFrameBodyText() {
        String text = driver.findElement(frameBody).getText();
        log.info("Frame body text: " + text);
        return text;
    }
}
