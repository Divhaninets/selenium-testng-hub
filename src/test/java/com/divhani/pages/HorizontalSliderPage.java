package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(HorizontalSliderPage.class);

    private By slider = By.cssSelector("input[type='range']");
    private By sliderValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        log.info("Navigated to Horizontal Slider page");
    }

    public void moveSliderRight(int times) {
        WebElement sliderElement = WaitUtil.waitForVisibility(driver, slider);
        for (int i = 0; i < times; i++) {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
        }
        log.info("Moved slider right " + times + " times");
    }

    public void moveSliderLeft(int times) {
        WebElement sliderElement = WaitUtil.waitForVisibility(driver, slider);
        for (int i = 0; i < times; i++) {
            sliderElement.sendKeys(Keys.ARROW_LEFT);
        }
        log.info("Moved slider left " + times + " times");
    }

    public String getSliderValue() {
        String value = driver.findElement(sliderValue).getText();
        log.info("Slider value: " + value);
        return value;
    }
}
