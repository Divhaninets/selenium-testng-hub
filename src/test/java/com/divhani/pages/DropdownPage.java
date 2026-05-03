package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(DropdownPage.class);

    // --- LOCATORS ---
    // ID is perfect here - unique and stable
    private By dropdown = By.id("dropdown");

    // --- CONSTRUCTOR ---
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- ACTIONS ---

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        log.info("Navigated to Dropdown page");
    }

    // SELECT BY VISIBLE TEXT
    // Selects the option the user can see on screen
    // Most readable and most commonly used in tests
    public void selectByVisibleText(String text) {
        WebElement dropdownElement = WaitUtil.waitForVisibility(driver, dropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
        log.info("Selected option by visible text: " + text);
    }

    // SELECT BY VALUE
    // Selects using the HTML value attribute
    // Good when text might change but value stays the same
    public void selectByValue(String value) {
        WebElement dropdownElement = WaitUtil.waitForVisibility(driver, dropdown);
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
        log.info("Selected option by value: " + value);
    }

    // SELECT BY INDEX
    // Selects by position - index starts at 0
    // 0 = "Please select an option" (disabled)
    // 1 = "Option 1"
    // 2 = "Option 2"
    public void selectByIndex(int index) {
        WebElement dropdownElement = WaitUtil.waitForVisibility(driver, dropdown);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
        log.info("Selected option by index: " + index);
    }

    // --- VALIDATIONS ---

    // Returns the currently selected option text
    public String getSelectedOption() {
        WebElement dropdownElement = WaitUtil.waitForVisibility(driver, dropdown);
        Select select = new Select(dropdownElement);
        String selected = select.getFirstSelectedOption().getText();
        log.info("Currently selected option: " + selected);
        return selected;
    }
}