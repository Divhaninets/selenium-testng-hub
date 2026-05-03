package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.KeyPressesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(KeyPressesTest.class);
    KeyPressesPage keyPressesPage;

    @Test
    public void pressEscapeKeyTest() {
        log.info("Starting pressEscapeKeyTest");
        keyPressesPage = new KeyPressesPage(driver);

        keyPressesPage.navigateTo();
        keyPressesPage.pressEscape();

        Assert.assertTrue(keyPressesPage.getResultText().contains("ESCAPE"),
                "Result should show ESCAPE was pressed");
        log.info("pressEscapeKeyTest passed");
    }

    @Test
    public void pressTabKeyTest() {
        log.info("Starting pressTabKeyTest");
        keyPressesPage = new KeyPressesPage(driver);

        keyPressesPage.navigateTo();
        keyPressesPage.pressTab();

        Assert.assertTrue(keyPressesPage.getResultText().contains("TAB"),
                "Result should show TAB was pressed");
        log.info("pressTabKeyTest passed");
    }

    @Test
    public void pressArrowDownTest() {
        log.info("Starting pressArrowDownTest");
        keyPressesPage = new KeyPressesPage(driver);

        keyPressesPage.navigateTo();
        keyPressesPage.pressArrowDown();

        Assert.assertTrue(keyPressesPage.getResultText().contains("DOWN"),
                "Result should show DOWN was pressed");
        log.info("pressArrowDownTest passed");
    }
}