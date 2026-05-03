package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.GeolocationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeolocationTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(GeolocationTest.class);
    GeolocationPage geolocationPage;

    @Test
    public void geolocationPageLoadsTest() {
        log.info("Starting geolocationPageLoadsTest");
        geolocationPage = new GeolocationPage(driver);

        geolocationPage.navigateTo();
        Assert.assertTrue(geolocationPage.pageLoaded(),
                "Geolocation page should load");
        log.info("geolocationPageLoadsTest passed");
    }

    @Test
    public void mockGeolocationTest() {
        log.info("Starting mockGeolocationTest");
        geolocationPage = new GeolocationPage(driver);

        geolocationPage.navigateTo();
        geolocationPage.setMockGeolocation(-25.7461, 28.1881);
        geolocationPage.clickWhereAmI();

        // Wait a moment for geolocation to process
        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        Assert.assertTrue(geolocationPage.pageLoaded(),
                "Page should still be loaded after geolocation");
        log.info("mockGeolocationTest passed");
    }
}