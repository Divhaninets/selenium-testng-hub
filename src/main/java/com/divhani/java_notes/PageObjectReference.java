package com.divhani.java_notes;

/**
 * PAGE OBJECT MODEL — REFERENCE GUIDE
 * =====================================
 * This class is NOT a test class.
 * It explains the Page Object Model (POM) design pattern
 * which is the most important pattern in Selenium automation.
 *
 * WHAT IS POM?
 * A design pattern where each web page has its own Java class.
 * The class contains:
 * 1. Locators — how to find elements on that page
 * 2. Actions  — what a user can do on that page
 *
 * WHY USE POM?
 * Without POM — locators and test logic are mixed together.
 * If a locator changes, you update it in EVERY test. Painful.
 *
 * With POM — locators live in ONE place (the page class).
 * If a locator changes, you update it in ONE place. Easy.
 *
 * This is called the DRY principle: Don't Repeat Yourself.
 */
public class PageObjectReference {

// =====================================================================
// STRUCTURE OF A PAGE OBJECT CLASS
// =====================================================================

// 1. PACKAGE — which page this belongs to
// package com.divhani.pages;

// 2. IMPORTS — what libraries this page needs
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;

// 3. CLASS DECLARATION
// public class LoginPage {

// 4. DRIVER INSTANCE — private so only this class uses it
// private WebDriver driver;

// 5. LOCATORS — private, named clearly, one per element
// private By usernameField = By.id("username");
// private By passwordField = By.id("password");
// private By loginButton  = By.cssSelector("button[type='submit']");
// private By flashMessage = By.id("flash");

// 6. CONSTRUCTOR — receives driver from the test class
// public LoginPage(WebDriver driver) {
//     this.driver = driver;
// }

// 7. ACTIONS — public methods, one per user action
// public void navigateTo() {
//     driver.get("https://the-internet.herokuapp.com/login");
// }
// public void enterUsername(String username) {
//     driver.findElement(usernameField).sendKeys(username);
// }
// public void clickLogin() {
//     driver.findElement(loginButton).click();
// }

// 8. COMBINED ACTIONS — shortcuts for common flows
// public void loginWith(String username, String password) {
//     enterUsername(username);
//     enterPassword(password);
//     clickLogin();
// }

// 9. VALIDATIONS — return values for assertions in tests
// public String getFlashMessage() {
//     return driver.findElement(flashMessage).getText();
// }
// public boolean isLoginButtonVisible() {
//     return driver.findElement(loginButton).isDisplayed();
// }

// =====================================================================
// STRUCTURE OF A TEST CLASS
// =====================================================================

// 1. EXTENDS BaseTest — inherits driver, setUp, tearDown
// public class LoginTest extends BaseTest {

// 2. PAGE OBJECT INSTANCE — declared at class level
// LoginPage loginPage;

// 3. TEST METHOD — annotated with @Test
// @Test
// public void validLoginTest() {

// 4. CREATE PAGE OBJECT — pass in driver from BaseTest
//     loginPage = new LoginPage(driver);

// 5. USE PAGE ACTIONS — readable, no Selenium code visible
//     loginPage.navigateTo();
//     loginPage.loginWith("tomsmith", "SuperSecretPassword!");

// 6. ASSERT — verify the expected outcome
//     Assert.assertTrue(loginPage.getFlashMessage().contains("secure area"));
// }

// =====================================================================
// POM NAMING CONVENTIONS
// =====================================================================
// Page classes:  LoginPage.java, CheckboxesPage.java, DropdownPage.java
// Test classes:  LoginTest.java, CheckboxesTest.java, DropdownTest.java
// One page class per web page
// One test class per web page
// Page class name = page name + "Page"
// Test class name = page name + "Test"

// =====================================================================
// WHAT GOES IN MAIN vs TEST FOLDER
// =====================================================================
// src/main/java — code that doesn't depend on TestNG
//   utils/       — WaitUtil,
}
