package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.BrokenImagesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class BrokenImagesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(BrokenImagesTest.class);
    BrokenImagesPage brokenImagesPage;

    @Test
    public void pageHasImagesTest() {
        log.info("Starting pageHasImagesTest");
        brokenImagesPage = new BrokenImagesPage(driver);

        brokenImagesPage.navigateTo();

        Assert.assertTrue(brokenImagesPage.getTotalImageCount() > 0,
                "Page should have images");
        log.info("pageHasImagesTest passed");
    }

    @Test
    public void brokenImagesExistTest() {
        log.info("Starting brokenImagesExistTest");
        brokenImagesPage = new BrokenImagesPage(driver);

        brokenImagesPage.navigateTo();

        List<String> brokenUrls = brokenImagesPage.getBrokenImageUrls();
        log.info("Broken images found: " + brokenUrls);

        Assert.assertTrue(brokenUrls.size() > 0,
                "Page should have at least one broken image");
        log.info("brokenImagesExistTest passed");
    }

    @Test
    public void validImagesExistTest() {
        log.info("Starting validImagesExistTest");
        brokenImagesPage = new BrokenImagesPage(driver);

        brokenImagesPage.navigateTo();

        Assert.assertTrue(brokenImagesPage.getValidImageCount() > 0,
                "Page should have at least one valid image");
        log.info("validImagesExistTest passed");
    }
}
