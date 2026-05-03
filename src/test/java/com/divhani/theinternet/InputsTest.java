package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.InputsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(InputsTest.class);
    InputsPage inputsPage;

    @Test
    public void enterNumberTest() {
        log.info("Starting enterNumberTest");
        inputsPage = new InputsPage(driver);

        inputsPage.navigateTo();
        inputsPage.enterNumber("10");

        Assert.assertEquals(inputsPage.getInputValue(), "10",
                "Input should contain 10");
        log.info("enterNumberTest passed");
    }

    @Test
    public void incrementWithArrowUpTest() {
        log.info("Starting incrementWithArrowUpTest");
        inputsPage = new InputsPage(driver);

        inputsPage.navigateTo();
        inputsPage.enterNumber("5");
        inputsPage.incrementWithArrowUp(3);

        Assert.assertEquals(inputsPage.getInputValue(), "8",
                "Value should be 8 after incrementing 3 times from 5");
        log.info("incrementWithArrowUpTest passed");
    }

    @Test
    public void decrementWithArrowDownTest() {
        log.info("Starting decrementWithArrowDownTest");
        inputsPage = new InputsPage(driver);

        inputsPage.navigateTo();
        inputsPage.enterNumber("10");
        inputsPage.decrementWithArrowDown(4);

        Assert.assertEquals(inputsPage.getInputValue(), "6",
                "Value should be 6 after decrementing 4 times from 10");
        log.info("decrementWithArrowDownTest passed");
    }
}
