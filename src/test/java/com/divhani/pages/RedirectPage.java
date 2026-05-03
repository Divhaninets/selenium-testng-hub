package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(RedirectPage.class);

    private By redirectLink = By.linkText("here");

    public RedirectPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/redirector");
        log.info("Navigated to Redirect page");
    }

    public void clickRedirectLink() {
        WaitUtil.waitForClickability(driver, redirectLink).click();
        log.info("Clicked redirect link");
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        log.info("Current URL: " + url);
        return url;
    }

    public String getCurrentPageTitle() {
        String title = driver.getTitle();
        log.info("Current page title: " + title);
        return title;
    }
}
