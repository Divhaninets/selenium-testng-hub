package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TyposPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(TyposPage.class);

    private By paragraphs = By.tagName("p");

    public TyposPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/typos");
        log.info("Navigated to Typos page");
    }

    // Get the second paragraph which sometimes has a typo
    public String getSecondParagraphText() {
        java.util.List<org.openqa.selenium.WebElement> paras =
                driver.findElements(paragraphs);
        String text = paras.get(1).getText();
        log.info("Second paragraph: " + text);
        return text;
    }

    public boolean pageLoaded() {
        return driver.findElements(paragraphs).size() > 0;
    }
}