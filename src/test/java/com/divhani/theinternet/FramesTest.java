package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.FramesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(FramesTest.class);
    FramesPage framesPage;

    @Test
    public void switchIntoIFrameTest() {
        log.info("Starting switchIntoIFrameTest");
        framesPage = new FramesPage(driver);

        framesPage.navigateToIFrame();
        framesPage.switchToIFrame();

        // Verify we are inside the iFrame by checking body text
        String bodyText = framesPage.getIFrameBodyText();
        Assert.assertFalse(bodyText.isEmpty(),
                "iFrame body should contain text");

        log.info("switchIntoIFrameTest passed");
    }

    @Test
    public void switchBackToMainPageTest() {
        log.info("Starting switchBackToMainPageTest");
        framesPage = new FramesPage(driver);

        framesPage.navigateToIFrame();
        framesPage.switchToIFrame();

        // Verify we are inside the iFrame
        String bodyText = framesPage.getIFrameBodyText();
        Assert.assertFalse(bodyText.isEmpty(), "iFrame body should contain text");

        // Switch back to main page
        framesPage.switchToMainPage();

        // Verify we are NOT inside a frame anymore by checking URL
        Assert.assertTrue(driver.getCurrentUrl().contains("iframe"),
                "Should be back on the iFrame page");
        log.info("switchBackToMainPageTest passed");
    }

    @Test
    public void switchToNestedFrameTest() {
        log.info("Starting switchToNestedFrameTest");
        framesPage = new FramesPage(driver);

        framesPage.navigateToNestedFrames();

        // Verify URL contains nested_frames
        Assert.assertTrue(driver.getCurrentUrl().contains("nested_frames"),
                "Should be on the nested frames page");

        // Switch into frames by name
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        String leftText = driver.findElement(By.tagName("body")).getText();
        Assert.assertEquals(leftText, "LEFT", "Left frame should contain LEFT");

        log.info("switchToNestedFrameTest passed");
    }
}
