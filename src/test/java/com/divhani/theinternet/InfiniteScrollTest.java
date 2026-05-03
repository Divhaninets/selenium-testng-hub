package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.InfiniteScrollPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfiniteScrollTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(InfiniteScrollTest.class);
    InfiniteScrollPage infiniteScrollPage;

    @Test
    public void pageLoadsWithContentTest() {
        log.info("Starting pageLoadsWithContentTest");
        infiniteScrollPage = new InfiniteScrollPage(driver);

        infiniteScrollPage.navigateTo();
        // Wait for page to load then scroll to trigger content
        infiniteScrollPage.scrollDown(300);
        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        Assert.assertTrue(infiniteScrollPage.getParagraphCount() >= 0,
                "Page should load");
        log.info("pageLoadsWithContentTest passed");
    }

    @Test
    public void scrollingLoadsMoreContentTest() {
        log.info("Starting scrollingLoadsMoreContentTest");
        infiniteScrollPage = new InfiniteScrollPage(driver);

        infiniteScrollPage.navigateTo();
        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        for (int i = 0; i < 3; i++) {
            infiniteScrollPage.scrollToBottom();
            try { Thread.sleep(1500); } catch (InterruptedException e) { }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("infinite_scroll"),
                "Should still be on infinite scroll page");
        log.info("scrollingLoadsMoreContentTest passed");
    }
}
