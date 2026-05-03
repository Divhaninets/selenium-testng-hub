package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // The driver instance passed in from BaseTest
    private WebDriver driver;

    // --- LOCATORS ---
    // These find the elements on the page
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.id("flash");
    private By successMessage = By.id("flash");

    // --- CONSTRUCTOR ---
    // When we create a LoginPage object we pass in the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- ACTIONS ---
    // These are the things a user can do on this page

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getFlashMessage() {
        WaitUtil.waitForVisibility(driver, successMessage);
        return driver.findElement(successMessage).getText();
    }

    // --- COMBINED ACTION ---
    // Login in one step - used when we don't need to test each field separately
    public void loginWith(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
