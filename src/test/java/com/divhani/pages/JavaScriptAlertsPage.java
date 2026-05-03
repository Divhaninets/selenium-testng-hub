package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(JavaScriptAlertsPage.class);

    // --- LOCATORS ---
    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    // --- CONSTRUCTOR ---
    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- ACTIONS ---

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        log.info("Navigated to JavaScript Alerts page");
    }

    // ALERT - click button, wait for alert, accept it
    public void clickAlertAndAccept() {
        WaitUtil.waitForClickability(driver, jsAlertButton).click();
        log.info("Clicked JS Alert button");

        // Wait for alert to appear then switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Get the alert text before accepting
        String alertText = alert.getText();
        log.info("Alert text: " + alertText);

        // Accept = click OK
        alert.accept();
        log.info("Alert accepted");
    }

    // CONFIRM - click button, accept or dismiss
    public void clickConfirmAndAccept() {
        WaitUtil.waitForClickability(driver, jsConfirmButton).click();
        log.info("Clicked JS Confirm button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        log.info("Confirm text: " + alert.getText());

        alert.accept(); // clicks OK
        log.info("Confirm accepted");
    }

    public void clickConfirmAndDismiss() {
        WaitUtil.waitForClickability(driver, jsConfirmButton).click();
        log.info("Clicked JS Confirm button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.dismiss(); // clicks Cancel
        log.info("Confirm dismissed");
    }

    // PROMPT - click button, type text, accept
    public void clickPromptAndEnterText(String text) {
        WaitUtil.waitForClickability(driver, jsPromptButton).click();
        log.info("Clicked JS Prompt button");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Type text into the prompt input
        alert.sendKeys(text);
        log.info("Entered text in prompt: " + text);

        alert.accept();
        log.info("Prompt accepted");
    }

    // --- VALIDATIONS ---

    public String getResultText() {
        WaitUtil.waitForVisibility(driver, resultText);
        String result = driver.findElement(resultText).getText();
        log.info("Result text: " + result);
        return result;
    }
}