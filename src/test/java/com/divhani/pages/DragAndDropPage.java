package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(DragAndDropPage.class);

    // Locators
    private By boxA = By.id("column-a");
    private By boxB = By.id("column-b");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        log.info("Navigated to Drag and Drop page");
    }

    // Get the text inside a box to verify position
    public String getBoxAText() {
        String text = driver.findElement(boxA).getText();
        log.info("Box A contains: " + text);
        return text;
    }

    public String getBoxBText() {
        String text = driver.findElement(boxB).getText();
        log.info("Box B contains: " + text);
        return text;
    }

    // METHOD 1 - dragAndDrop() — simplest approach
    public void dragAToB() {
        WebElement source = WaitUtil.waitForVisibility(driver, boxA);
        WebElement target = WaitUtil.waitForVisibility(driver, boxB);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        log.info("Dragged Box A to Box B using dragAndDrop()");
    }

    // METHOD 2 - clickAndHold + moveToElement + release — more control
    public void dragAToBManually() {
        WebElement source = WaitUtil.waitForVisibility(driver, boxA);
        WebElement target = WaitUtil.waitForVisibility(driver, boxB);
        Actions actions = new Actions(driver);
        actions.clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();
        log.info("Dragged Box A to Box B manually using clickAndHold");
    }
}