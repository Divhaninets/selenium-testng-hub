package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.AddRemoveElementsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(AddRemoveElementsTest.class);
    AddRemoveElementsPage addRemovePage;

    @Test
    public void addSingleElementTest() {
        log.info("Starting addSingleElementTest");
        addRemovePage = new AddRemoveElementsPage(driver);

        addRemovePage.navigateTo();
        Assert.assertEquals(addRemovePage.getDeleteButtonCount(), 0,
                "Should start with no delete buttons");

        addRemovePage.clickAddElement();
        Assert.assertEquals(addRemovePage.getDeleteButtonCount(), 1,
                "Should have 1 delete button after adding");
        log.info("addSingleElementTest passed");
    }

    @Test
    public void addMultipleElementsTest() {
        log.info("Starting addMultipleElementsTest");
        addRemovePage = new AddRemoveElementsPage(driver);

        addRemovePage.navigateTo();
        addRemovePage.clickAddElementTimes(5);

        Assert.assertEquals(addRemovePage.getDeleteButtonCount(), 5,
                "Should have 5 delete buttons after adding 5 times");
        log.info("addMultipleElementsTest passed");
    }

    @Test
    public void removeElementTest() {
        log.info("Starting removeElementTest");
        addRemovePage = new AddRemoveElementsPage(driver);

        addRemovePage.navigateTo();
        addRemovePage.clickAddElement();
        addRemovePage.clickAddElement();
        Assert.assertEquals(addRemovePage.getDeleteButtonCount(), 2,
                "Should have 2 delete buttons");

        addRemovePage.clickDeleteButton(0);
        Assert.assertEquals(addRemovePage.getDeleteButtonCount(), 1,
                "Should have 1 delete button after removing one");
        log.info("removeElementTest passed");
    }

    @Test
    public void deleteAllElementsTest() {
        log.info("Starting deleteAllElementsTest");
        addRemovePage = new AddRemoveElementsPage(driver);

        addRemovePage.navigateTo();
        addRemovePage.clickAddElementTimes(3);
        addRemovePage.deleteAllElements();

        Assert.assertFalse(addRemovePage.isDeleteButtonPresent(),
                "No delete buttons should remain");
        log.info("deleteAllElementsTest passed");
    }
}