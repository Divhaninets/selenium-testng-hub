package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    // LoginPage object - our connection to the page
    LoginPage loginPage;

    @Test
    public void validLoginTest() {
        // Step 1 - Create the page object and pass in the driver from BaseTest
        loginPage = new LoginPage(driver);

        // Step 2 - Navigate to the login page
        loginPage.navigateTo();

        // Step 3 - Login with valid credentials
        loginPage.loginWith("tomsmith", "SuperSecretPassword!");

        // Step 4 - Verify we logged in successfully
        String flashMessage = loginPage.getFlashMessage();
        Assert.assertTrue(flashMessage.contains("You logged into a secure area!"),
                "Login failed - success message not found");
    }

    @Test
    public void invalidLoginTest() {
        // Step 1 - Create the page object
        loginPage = new LoginPage(driver);

        // Step 2 - Navigate to the login page
        loginPage.navigateTo();

        // Step 3 - Login with invalid credentials
        loginPage.loginWith("wronguser", "wrongpassword");

        // Step 4 - Verify error message appears
        String flashMessage = loginPage.getFlashMessage();
        Assert.assertTrue(flashMessage.contains("Your username is invalid!"),
                "Error message not displayed for invalid login");
    }
}
