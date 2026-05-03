package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.RedirectPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedirectTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(RedirectTest.class);
    RedirectPage redirectPage;

    @Test
    public void redirectsToCorrectPageTest() {
        log.info("Starting redirectsToCorrectPageTest");
        redirectPage = new RedirectPage(driver);

        redirectPage.navigateTo();
        String initialUrl = redirectPage.getCurrentUrl();
        log.info("Initial URL: " + initialUrl);

        redirectPage.clickRedirectLink();

        // After redirect URL should be different
        String finalUrl = redirectPage.getCurrentUrl();
        Assert.assertNotEquals(finalUrl, initialUrl,
                "URL should change after redirect");
        Assert.assertTrue(finalUrl.contains("status_codes"),
                "Should redirect to status codes page");
        log.info("redirectsToCorrectPageTest passed");
    }

    @Test
    public void redirectPageTitleTest() {
        log.info("Starting redirectPageTitleTest");
        redirectPage = new RedirectPage(driver);

        redirectPage.navigateTo();
        redirectPage.clickRedirectLink();

        Assert.assertEquals(redirectPage.getCurrentPageTitle(), "The Internet",
                "Redirected page title should be The Internet");
        log.info("redirectPageTitleTest passed");
    }
}