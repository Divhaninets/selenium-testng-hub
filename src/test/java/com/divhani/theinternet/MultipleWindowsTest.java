package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.MultipleWindowsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(MultipleWindowsTest.class);
    MultipleWindowsPage windowsPage;

    @Test
    public void newWindowOpensTest() {
        log.info("Starting newWindowOpensTest");
        windowsPage = new MultipleWindowsPage(driver);

        windowsPage.navigateTo();
        Assert.assertEquals(windowsPage.getTotalWindowCount(), 1,
                "Should start with 1 window");

        windowsPage.clickOpenNewWindow();
        Assert.assertEquals(windowsPage.getTotalWindowCount(), 2,
                "Should have 2 windows after clicking link");
        log.info("newWindowOpensTest passed");
    }

    @Test
    public void switchToNewWindowTest() {
        log.info("Starting switchToNewWindowTest");
        windowsPage = new MultipleWindowsPage(driver);

        windowsPage.navigateTo();
        windowsPage.clickOpenNewWindow();
        windowsPage.switchToNewWindow();

        Assert.assertEquals(windowsPage.getCurrentPageTitle(), "New Window",
                "New window title should be 'New Window'");
        log.info("switchToNewWindowTest passed");
    }

    @Test
    public void switchBackToOriginalWindowTest() {
        log.info("Starting switchBackToOriginalWindowTest");
        windowsPage = new MultipleWindowsPage(driver);

        windowsPage.navigateTo();
        windowsPage.clickOpenNewWindow();
        windowsPage.switchToNewWindow();
        windowsPage.switchBackToOriginalWindow();

        Assert.assertEquals(windowsPage.getCurrentPageTitle(), "The Internet",
                "Original window title should be 'The Internet'");
        log.info("switchBackToOriginalWindowTest passed");
    }
}