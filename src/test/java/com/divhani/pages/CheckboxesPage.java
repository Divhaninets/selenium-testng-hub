package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(CheckboxesPage.class);

    // --- LOCATORS ---
    // CSS - finds all checkboxes, nth-of-type is more reliable than nth-child here
    private By checkbox1 = By.cssSelector("input[type='checkbox']:nth-of-type(1)");
    private By checkbox2 = By.cssSelector("input[type='checkbox']:nth-of-type(2)");

    // Alternative XPath locators - kept as reference
    // private By checkbox1XPath = By.xpath("//*[@id='checkboxes']/input[1]");
    // private By checkbox2XPath = By.xpath("//*[@id='checkboxes']/input[2]");

    // --- CONSTRUCTOR ---
    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- ACTIONS ---

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        log.info("Navigated to Checkboxes page");
    }

    // Check a checkbox only if it is not already checked
    public void checkCheckbox1() {
        WebElement cb = driver.findElement(checkbox1);
        if (!cb.isSelected()) {
            cb.click();
            log.info("Checkbox 1 checked");
        } else {
            log.info("Checkbox 1 was already checked");
        }
    }

    public void checkCheckbox2() {
        WebElement cb = driver.findElement(checkbox2);
        if (!cb.isSelected()) {
            cb.click();
            log.info("Checkbox 2 checked");
        } else {
            log.info("Checkbox 2 was already checked");
        }
    }

    public void uncheckCheckbox1() {
        WebElement cb = driver.findElement(checkbox1);
        if (cb.isSelected()) {
            cb.click();
            log.info("Checkbox 1 unchecked");
        } else {
            log.info("Checkbox 1 was already unchecked");
        }
    }

    // --- VALIDATIONS ---
    // These return true/false so tests can assert against them

    public boolean isCheckbox1Selected() {
        boolean selected = driver.findElement(checkbox1).isSelected();
        log.info("Checkbox 1 selected: " + selected);
        return selected;
    }

    public boolean isCheckbox2Selected() {
        boolean selected = driver.findElement(checkbox2).isSelected();
        log.info("Checkbox 2 selected: " + selected);
        return selected;
    }
}