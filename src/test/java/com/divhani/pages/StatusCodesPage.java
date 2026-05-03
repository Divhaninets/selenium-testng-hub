package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(StatusCodesPage.class);

    private By code200 = By.linkText("200");
    private By code301 = By.linkText("301");
    private By code404 = By.linkText("404");
    private By code500 = By.linkText("500");
    private By pageText = By.tagName("p");

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
        log.info("Navigated to Status Codes page");
    }

    public void clickStatusCode(String code) {
        By locator = By.linkText(code);
        WaitUtil.waitForClickability(driver, locator).click();
        log.info("Clicked status code: " + code);
    }

    public String getPageText() {
        WaitUtil.waitForVisibility(driver, pageText);
        String text = driver.findElement(pageText).getText();
        log.info("Page text: " + text);
        return text;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}