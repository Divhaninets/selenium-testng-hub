package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.DropdownPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(DropdownTest.class);
    DropdownPage dropdownPage;

    @Test
    public void selectByVisibleTextTest() {
        log.info("Starting selectByVisibleTextTest");
        dropdownPage = new DropdownPage(driver);

        dropdownPage.navigateTo();
        dropdownPage.selectByVisibleText("Option 1");

        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1",
                "Option 1 should be selected");
        log.info("selectByVisibleTextTest passed");
    }

    @Test
    public void selectByValueTest() {
        log.info("Starting selectByValueTest");
        dropdownPage = new DropdownPage(driver);

        dropdownPage.navigateTo();
        dropdownPage.selectByValue("2");

        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 2",
                "Option 2 should be selected");
        log.info("selectByValueTest passed");
    }

    @Test
    public void selectByIndexTest() {
        log.info("Starting selectByIndexTest");
        dropdownPage = new DropdownPage(driver);

        dropdownPage.navigateTo();

        // Index 1 = Option 1, Index 2 = Option 2
        dropdownPage.selectByIndex(1);

        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 1",
                "Option 1 should be selected by index");
        log.info("selectByIndexTest passed");
    }
}
