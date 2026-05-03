package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddRemoveElementsPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(AddRemoveElementsPage.class);

    private By addButton = By.xpath("//button[text()='Add Element']");
    private By deleteButtons = By.className("added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        log.info("Navigated to Add/Remove Elements page");
    }

    public void clickAddElement() {
        WaitUtil.waitForClickability(driver, addButton).click();
        log.info("Clicked Add Element button");
    }

    public void clickAddElementTimes(int times) {
        for (int i = 0; i < times; i++) {
            clickAddElement();
        }
        log.info("Added " + times + " elements");
    }

    public int getDeleteButtonCount() {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        log.info("Delete button count: " + buttons.size());
        return buttons.size();
    }

    public void clickDeleteButton(int index) {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        buttons.get(index).click();
        log.info("Clicked delete button at index: " + index);
    }

    public void deleteAllElements() {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        int count = buttons.size();
        for (int i = 0; i < count; i++) {
            // Always click the first button since list updates after each delete
            driver.findElements(deleteButtons).get(0).click();
            log.info("Deleted element " + (i + 1));
        }
    }

    public boolean isDeleteButtonPresent() {
        return driver.findElements(deleteButtons).size() > 0;
    }
}
