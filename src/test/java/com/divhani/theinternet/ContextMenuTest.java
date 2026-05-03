package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.ContextMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(ContextMenuTest.class);
    ContextMenuPage contextMenuPage;

    @Test
    public void rightClickShowsAlertTest() {
        log.info("Starting rightClickShowsAlertTest");
        contextMenuPage = new ContextMenuPage(driver);

        contextMenuPage.navigateTo();
        contextMenuPage.rightClickHotspot();

        String alertText = contextMenuPage.getAlertText();
        Assert.assertTrue(alertText.contains("You selected a context menu"),
                "Alert should confirm context menu was selected");

        contextMenuPage.acceptAlert();
        log.info("rightClickShowsAlertTest passed");
    }
}