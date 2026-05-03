package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.HorizontalSliderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(HorizontalSliderTest.class);
    HorizontalSliderPage sliderPage;

    @Test
    public void moveSliderRightTest() {
        log.info("Starting moveSliderRightTest");
        sliderPage = new HorizontalSliderPage(driver);

        sliderPage.navigateTo();
        sliderPage.moveSliderRight(3);

        String value = sliderPage.getSliderValue();
        Assert.assertNotEquals(value, "0",
                "Slider value should change after moving right");
        log.info("moveSliderRightTest passed");
    }

    @Test
    public void sliderStartsAtZeroTest() {
        log.info("Starting sliderStartsAtZeroTest");
        sliderPage = new HorizontalSliderPage(driver);

        sliderPage.navigateTo();

        Assert.assertEquals(sliderPage.getSliderValue(), "0",
                "Slider should start at 0");
        log.info("sliderStartsAtZeroTest passed");
    }
}