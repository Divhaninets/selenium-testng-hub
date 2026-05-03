package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.ShadowDomPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShadowDomTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(ShadowDomTest.class);
    ShadowDomPage shadowDomPage;

    @Test
    public void shadowDomPageLoadsTest() {
        log.info("Starting shadowDomPageLoadsTest");
        shadowDomPage = new ShadowDomPage(driver);

        shadowDomPage.navigateTo();
        Assert.assertTrue(shadowDomPage.pageLoaded(),
                "Shadow DOM page should load");
        log.info("shadowDomPageLoadsTest passed");
    }

    @Test
    public void accessShadowDomContentTest() {
        log.info("Starting accessShadowDomContentTest");
        shadowDomPage = new ShadowDomPage(driver);

        shadowDomPage.navigateTo();
        String text = shadowDomPage.getShadowDomText();

        Assert.assertFalse(text.isEmpty(),
                "Should be able to read text from inside Shadow DOM");
        log.info("accessShadowDomContentTest passed");
    }
}
