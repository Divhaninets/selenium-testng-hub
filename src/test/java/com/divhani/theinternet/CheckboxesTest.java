package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.CheckboxesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(CheckboxesTest.class);
    CheckboxesPage checkboxesPage;

    @Test
    public void checkCheckbox1Test() {
        log.info("Starting checkCheckbox1Test");
        checkboxesPage = new CheckboxesPage(driver);

        checkboxesPage.navigateTo();
        checkboxesPage.checkCheckbox1();

        Assert.assertTrue(checkboxesPage.isCheckbox1Selected(),
                "Checkbox 1 should be checked but is not");
        log.info("checkCheckbox1Test passed");
    }

    @Test
    public void uncheckCheckbox1Test() {
        log.info("Starting uncheckCheckbox1Test");
        checkboxesPage = new CheckboxesPage(driver);

        checkboxesPage.navigateTo();

        // Checkbox 1 starts unchecked by default - check it first
        checkboxesPage.checkCheckbox1();
        Assert.assertTrue(checkboxesPage.isCheckbox1Selected(),
                "Checkbox 1 should be checked");

        // Now uncheck it
        checkboxesPage.uncheckCheckbox1();
        Assert.assertFalse(checkboxesPage.isCheckbox1Selected(),
                "Checkbox 1 should be unchecked");
        log.info("uncheckCheckbox1Test passed");
    }

    @Test
    public void checkbox2IsCheckedByDefaultTest() {
        log.info("Starting checkbox2IsCheckedByDefaultTest");
        checkboxesPage = new CheckboxesPage(driver);

        checkboxesPage.navigateTo();

        // Checkbox 2 is checked by default on this page
        Assert.assertTrue(checkboxesPage.isCheckbox2Selected(),
                "Checkbox 2 should be checked by default");
        log.info("checkbox2IsCheckedByDefaultTest passed");
    }
}
