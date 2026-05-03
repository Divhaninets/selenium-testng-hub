package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GeolocationPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(GeolocationPage.class);

    private By whereAmIButton = By.cssSelector("button");
    private By latitudeText = By.id("lat-value");
    private By longitudeText = By.id("long-value");

    public GeolocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/geolocation");
        log.info("Navigated to Geolocation page");
    }

    // Override geolocation using JavaScript before clicking button
    public void setMockGeolocation(double latitude, double longitude) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "window.navigator.geolocation.getCurrentPosition = function(success) {" +
                        "  success({coords: {latitude: " + latitude + ", longitude: " + longitude + "}});" +
                        "}"
        );
        log.info("Mock geolocation set: " + latitude + ", " + longitude);
    }

    public void clickWhereAmI() {
        driver.findElement(whereAmIButton).click();
        log.info("Clicked Where am I button");
    }

    public boolean pageLoaded() {
        return driver.getCurrentUrl().contains("geolocation");
    }
}