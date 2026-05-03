package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.JavaScriptAlertsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(JavaScriptAlertsTest.class);
    JavaScriptAlertsPage alertsPage;

    @Test
    public void jsAlertAcceptTest() {
        log.info("Starting jsAlertAcceptTest");
        alertsPage = new JavaScriptAlertsPage(driver);

        alertsPage.navigateTo();
        alertsPage.clickAlertAndAccept();

        Assert.assertEquals(alertsPage.getResultText(), "You successfully clicked an alert",
                "Result message should confirm alert was accepted");
        log.info("jsAlertAcceptTest passed");
    }

    @Test
    public void jsConfirmAcceptTest() {
        log.info("Starting jsConfirmAcceptTest");
        alertsPage = new JavaScriptAlertsPage(driver);

        alertsPage.navigateTo();
        alertsPage.clickConfirmAndAccept();

        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Ok",
                "Result should confirm OK was clicked");
        log.info("jsConfirmAcceptTest passed");
    }

    @Test
    public void jsConfirmDismissTest() {
        log.info("Starting jsConfirmDismissTest");
        alertsPage = new JavaScriptAlertsPage(driver);

        alertsPage.navigateTo();
        alertsPage.clickConfirmAndDismiss();

        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Cancel",
                "Result should confirm Cancel was clicked");
        log.info("jsConfirmDismissTest passed");
    }

    @Test
    public void jsPromptTest() {
        log.info("Starting jsPromptTest");
        alertsPage = new JavaScriptAlertsPage(driver);

        alertsPage.navigateTo();
        alertsPage.clickPromptAndEnterText("Divhani");

        Assert.assertEquals(alertsPage.getResultText(), "You entered: Divhani",
                "Result should show the text entered in prompt");
        log.info("jsPromptTest passed");
    }
}