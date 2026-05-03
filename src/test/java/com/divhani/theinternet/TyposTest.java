package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.TyposPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(TyposTest.class);
    TyposPage typosPage;

    @Test
    public void pageLoadsTest() {
        log.info("Starting pageLoadsTest");
        typosPage = new TyposPage(driver);

        typosPage.navigateTo();
        Assert.assertTrue(typosPage.pageLoaded(),
                "Typos page should load with content");
        log.info("pageLoadsTest passed");
    }

    @Test
    public void secondParagraphContainsExpectedWordsTest() {
        log.info("Starting secondParagraphContainsExpectedWordsTest");
        typosPage = new TyposPage(driver);

        typosPage.navigateTo();

        // Page randomly shows correct or typo version
        // We verify the paragraph contains the key words regardless of typo
        String text = typosPage.getSecondParagraphText();
        Assert.assertTrue(text.contains("Sometimes") || text.contains("sometimes"),
                "Paragraph should contain 'Sometimes'");
        log.info("secondParagraphContainsExpectedWordsTest passed");
    }
}
