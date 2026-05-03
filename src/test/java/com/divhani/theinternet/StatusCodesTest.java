package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.StatusCodesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusCodesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(StatusCodesTest.class);
    StatusCodesPage statusCodesPage;

    @Test
    public void status200Test() {
        log.info("Starting status200Test");
        statusCodesPage = new StatusCodesPage(driver);

        statusCodesPage.navigateTo();
        statusCodesPage.clickStatusCode("200");

        Assert.assertTrue(statusCodesPage.getCurrentUrl().contains("200"),
                "URL should contain 200");
        Assert.assertTrue(statusCodesPage.getPageText().contains("200"),
                "Page should mention status code 200");
        log.info("status200Test passed");
    }

    @Test
    public void status404Test() {
        log.info("Starting status404Test");
        statusCodesPage = new StatusCodesPage(driver);

        statusCodesPage.navigateTo();
        statusCodesPage.clickStatusCode("404");

        Assert.assertTrue(statusCodesPage.getCurrentUrl().contains("404"),
                "URL should contain 404");
        Assert.assertTrue(statusCodesPage.getPageText().contains("404"),
                "Page should mention status code 404");
        log.info("status404Test passed");
    }

    @Test
    public void status500Test() {
        log.info("Starting status500Test");
        statusCodesPage = new StatusCodesPage(driver);

        statusCodesPage.navigateTo();
        statusCodesPage.clickStatusCode("500");

        Assert.assertTrue(statusCodesPage.getCurrentUrl().contains("500"),
                "URL should contain 500");
        Assert.assertTrue(statusCodesPage.getPageText().contains("500"),
                "Page should mention status code 500");
        log.info("status500Test passed");
    }
}