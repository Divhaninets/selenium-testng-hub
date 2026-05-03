package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(HoversPage.class);

    // Locators
    private By figures = By.className("figure");
    private By figureCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        log.info("Navigated to Hovers page");
    }

    // Hover over a figure by index (0, 1, 2)
    public void hoverOverFigure(int index) {
        java.util.List<WebElement> allFigures = driver.findElements(figures);
        Actions actions = new Actions(driver);
        actions.moveToElement(allFigures.get(index)).perform();
        log.info("Hovered over figure at index: " + index);
    }

    // Get the caption text that appears after hovering
    public String getCaptionText(int index) {
        java.util.List<WebElement> captions = driver.findElements(figureCaption);
        String text = captions.get(index).getText();
        log.info("Caption text at index " + index + ": " + text);
        return text;
    }

    // Check if caption is visible after hover
    public boolean isCaptionVisible(int index) {
        java.util.List<WebElement> captions = driver.findElements(figureCaption);
        boolean visible = captions.get(index).isDisplayed();
        log.info("Caption visible at index " + index + ": " + visible);
        return visible;
    }
}
