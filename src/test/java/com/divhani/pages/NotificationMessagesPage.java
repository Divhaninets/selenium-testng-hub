package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(NotificationMessagesPage.class);

    private By clickHereLink = By.linkText("Click here");
    private By flashMessage = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/notification_message");
        log.info("Navigated to Notification Messages page");
    }

    public void clickHere() {
        WaitUtil.waitForClickability(driver, clickHereLink).click();
        log.info("Clicked the link");
    }

    public String getNotificationMessage() {
        WaitUtil.waitForVisibility(driver, flashMessage);
        String message = driver.findElement(flashMessage).getText();
        log.info("Notification message: " + message);
        return message;
    }

    public boolean isNotificationDisplayed() {
        boolean displayed = driver.findElement(flashMessage).isDisplayed();
        log.info("Notification displayed: " + displayed);
        return displayed;
    }
}