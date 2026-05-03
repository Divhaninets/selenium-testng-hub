package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.DragAndDropPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(DragAndDropTest.class);
    DragAndDropPage dragAndDropPage;

    @Test
    public void dragAndDropTest() {
        log.info("Starting dragAndDropTest");
        dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.navigateTo();

        // Verify initial state
        Assert.assertEquals(dragAndDropPage.getBoxAText(), "A",
                "Box A should initially contain A");
        Assert.assertEquals(dragAndDropPage.getBoxBText(), "B",
                "Box B should initially contain B");

        // Perform drag and drop
        dragAndDropPage.dragAToB();

        // After drag - A and B should be swapped
        Assert.assertEquals(dragAndDropPage.getBoxAText(), "B",
                "Box A should now contain B after drag");
        Assert.assertEquals(dragAndDropPage.getBoxBText(), "A",
                "Box B should now contain A after drag");

        log.info("dragAndDropTest passed");
    }
}
