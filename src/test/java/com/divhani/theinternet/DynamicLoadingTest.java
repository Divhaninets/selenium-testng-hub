package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.DynamicLoadingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(DynamicLoadingTest.class);
    DynamicLoadingPage dynamicLoadingPage;

    @Test
    public void example1HiddenElementTest() {
        log.info("Starting example1HiddenElementTest");
        dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.navigateToExample1();
        dynamicLoadingPage.clickStart();

        // Without explicit wait this would fail
        // With explicit wait we wait until Hello World appears
        String text = dynamicLoadingPage.getFinishText();
        Assert.assertEquals(text, "Hello World!",
                "Hello World should appear after loading");
        log.info("example1HiddenElementTest passed");
    }

    @Test
    public void example2ElementAddedTest() {
        log.info("Starting example2ElementAddedTest");
        dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.navigateToExample2();
        dynamicLoadingPage.clickStart();

        // Example 2 - element doesn't exist until loading finishes
        String text = dynamicLoadingPage.getFinishText();
        Assert.assertEquals(text, "Hello World!",
                "Hello World should appear after element is added to DOM");
        log.info("example2ElementAddedTest passed");
    }
}
