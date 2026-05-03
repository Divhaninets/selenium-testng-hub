package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.FloatingMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(FloatingMenuTest.class);
    FloatingMenuPage floatingMenuPage;

    @Test
    public void menuVisibleOnLoadTest() {
        log.info("Starting menuVisibleOnLoadTest");
        floatingMenuPage = new FloatingMenuPage(driver);

        floatingMenuPage.navigateTo();
        Assert.assertTrue(floatingMenuPage.isMenuDisplayed(),
                "Menu should be visible on page load");
        log.info("menuVisibleOnLoadTest passed");
    }

    @Test
    public void menuStaysVisibleAfterScrollTest() {
        log.info("Starting menuStaysVisibleAfterScrollTest");
        floatingMenuPage = new FloatingMenuPage(driver);

        floatingMenuPage.navigateTo();
        floatingMenuPage.scrollDown(500);

        Assert.assertTrue(floatingMenuPage.isMenuDisplayed(),
                "Menu should stay visible after scrolling");
        Assert.assertTrue(floatingMenuPage.isHomeLinkDisplayed(),
                "Home link should stay visible after scrolling");
        log.info("menuStaysVisibleAfterScrollTest passed");
    }
}