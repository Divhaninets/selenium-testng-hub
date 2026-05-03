package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.HoversPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(HoversTest.class);
    HoversPage hoversPage;

    @Test
    public void hoverOverFirstFigureTest() {
        log.info("Starting hoverOverFirstFigureTest");
        hoversPage = new HoversPage(driver);

        hoversPage.navigateTo();
        hoversPage.hoverOverFigure(0);

        Assert.assertTrue(hoversPage.isCaptionVisible(0),
                "Caption should be visible after hovering");
        log.info("hoverOverFirstFigureTest passed");
    }

    @Test
    public void hoverCaptionTextTest() {
        log.info("Starting hoverCaptionTextTest");
        hoversPage = new HoversPage(driver);

        hoversPage.navigateTo();
        hoversPage.hoverOverFigure(0);

        String captionText = hoversPage.getCaptionText(0);
        Assert.assertTrue(captionText.contains("name: user1"),
                "Caption should contain user1 name");
        log.info("hoverCaptionTextTest passed");
    }

    @Test
    public void hoverOverAllFiguresTest() {
        log.info("Starting hoverOverAllFiguresTest");
        hoversPage = new HoversPage(driver);

        hoversPage.navigateTo();

        // Hover over all 3 figures
        for (int i = 0; i < 3; i++) {
            hoversPage.hoverOverFigure(i);
            Assert.assertTrue(hoversPage.isCaptionVisible(i),
                    "Caption should be visible for figure " + i);
            log.info("Figure " + i + " hover verified");
        }
        log.info("hoverOverAllFiguresTest passed");
    }
}
