package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContextMenuPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(ContextMenuPage.class);

    private By hotspot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        log.info("Navigated to Context Menu page");
    }

    // Right click on the hot spot area
    public void rightClickHotspot() {
        WebElement hotspotElement = WaitUtil.waitForVisibility(driver, hotspot);
        Actions actions = new Actions(driver);
        actions.contextClick(hotspotElement).perform();
        log.info("Right clicked on hotspot");
    }

    // Get the alert text that appears after right click
    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        log.info("Alert text: " + text);
        return text;
    }

    // Accept the alert
    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        log.info("Alert accepted");
    }
}