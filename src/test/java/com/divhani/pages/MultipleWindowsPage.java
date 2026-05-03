package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(MultipleWindowsPage.class);

    private By clickHereLink = By.linkText("Click Here");
    private String originalWindow;

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/windows");
        // Store the original window handle before opening new ones
        originalWindow = driver.getWindowHandle();
        log.info("Navigated to Multiple Windows page. Original window: " + originalWindow);
    }

    public void clickOpenNewWindow() {
        WaitUtil.waitForClickability(driver, clickHereLink).click();
        log.info("Clicked link to open new window");
    }

    public void switchToNewWindow() {
        // Get all window handles
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        log.info("Total windows open: " + allWindows.size());

        // Switch to the window that is NOT the original
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                log.info("Switched to new window: " + window);
                break;
            }
        }
    }

    public void switchBackToOriginalWindow() {
        driver.switchTo().window(originalWindow);
        log.info("Switched back to original window");
    }

    public String getCurrentPageTitle() {
        String title = driver.getTitle();
        log.info("Current page title: " + title);
        return title;
    }

    public int getTotalWindowCount() {
        return driver.getWindowHandles().size();
    }
}
