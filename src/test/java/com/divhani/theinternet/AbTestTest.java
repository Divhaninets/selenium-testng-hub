package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.AbTestPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AbTestTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(AbTestTest.class);
    AbTestPage abTestPage;

    @Test
    public void abTestPageLoadsTest() {
        log.info("Starting abTestPageLoadsTest");
        abTestPage = new AbTestPage(driver);

        abTestPage.navigateTo();

        // Page shows either variant A or variant B heading
        String heading = abTestPage.getHeadingText();
        boolean isValidVariant = heading.contains("A/B Test") ||
                heading.contains("No A/B Test");

        Assert.assertTrue(isValidVariant,
                "Page should show a valid A/B test variant but showed: " + heading);
        log.info("abTestPageLoadsTest passed");
    }
}
