package com.divhani.java_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JAVA BASICS FOR AUTOMATION — REFERENCE GUIDE
 * =============================================
 * This class is NOT a test class.
 * It is a REFERENCE LIBRARY of Java concepts used in automation.
 * Come here when you forget how something works.
 *
 * Topics covered:
 * 1. Variables and Data Types
 * 2. String methods
 * 3. Conditionals
 * 4. Loops
 * 5. Arrays and Lists
 * 6. Maps (HashMap)
 * 7. Methods
 * 8. Exception handling
 * 9. OOP concepts used in automation
 */
public class JavaBasicsForAutomation {

    // =====================================================================
    // 1. VARIABLES AND DATA TYPES
    // =====================================================================
    // Most common types used in automation:

    String pageName = "Login Page";           // text
    int timeout = 10;                          // whole numbers
    boolean isLoggedIn = false;                // true/false
    double price = 99.99;                      // decimal numbers

    // final = constant, value cannot change
    // Used for locators, URLs, credentials in tests
    final String BASE_URL = "https://the-internet.herokuapp.com";
    final int DEFAULT_WAIT = 10;

    // =====================================================================
    // 2. STRING METHODS — used constantly in automation
    // =====================================================================
    public void stringExamples() {
        String text = "  Hello World!  ";

        // Remove whitespace from both ends — use after getText()
        String trimmed = text.trim(); // "Hello World!"

        // Check if text contains a word — use in assertions
        boolean contains = text.contains("World"); // true

        // Convert to lowercase — use when comparing text case-insensitively
        String lower = text.toLowerCase(); // "  hello world!  "

        // Replace text
        String replaced = text.replace("World", "Selenium"); // "  Hello Selenium!  "

        // Split into array — use when parsing table data
        String csv = "Smith,John,jsmith@gmail.com";
        String[] parts = csv.split(","); // ["Smith", "John", "jsmith@gmail.com"]

        // Check if empty — use to verify fields are filled
        boolean isEmpty = "".isEmpty(); // true

        // Get length
        int length = text.length(); // 16

        // startsWith / endsWith — use to verify URLs or messages
        boolean startsWithHttp = BASE_URL.startsWith("https"); // true
    }

    // =====================================================================
    // 3. CONDITIONALS — used in page objects for smart actions
    // =====================================================================
    public void conditionalExamples(boolean isCheckboxSelected) {

        // If/else — used in checkbox, dropdown, and state checks
        if (isCheckboxSelected) {
            System.out.println("Checkbox is checked");
        } else {
            System.out.println("Checkbox is unchecked");
        }

        // Ternary operator — shorthand if/else
        String status = isCheckboxSelected ? "checked" : "unchecked";

        // Used in page objects like this:
        // if (!element.isSelected()) { element.click(); }
    }

    // =====================================================================
    // 4. LOOPS — used to iterate over table rows, dropdowns, lists
    // =====================================================================
    public void loopExamples() {

        // For loop — when you know the exact count
        for (int i = 0; i < 5; i++) {
            System.out.println("Row " + i);
        }

        // Enhanced for loop — iterating over a list (most common in automation)
        List<String> emails = Arrays.asList("a@test.com", "b@test.com");
        for (String email : emails) {
            System.out.println(email);
        }

        // While loop — used with waits and retries
        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Attempt: " + attempts);
            attempts++;
        }
    }

    // =====================================================================
    // 5. ARRAYS AND LISTS — storing multiple values
    // =====================================================================
    public void collectionsExamples() {

        // Array — fixed size, rarely used in automation
        String[] browsers = {"chrome", "firefox", "edge"};

        // ArrayList — dynamic size, most common in automation
        // Used to store WebElements, test data, window handles
        List<String> windowHandles = new ArrayList<>();
        windowHandles.add("handle1");
        windowHandles.add("handle2");
        windowHandles.remove("handle1");
        int size = windowHandles.size(); // 1
        boolean hasHandle = windowHandles.contains("handle2"); // true
    }

    // =====================================================================
    // 6. HASHMAP — key-value pairs for test data
    // =====================================================================
    public void hashMapExamples() {

        // HashMap — used to store test data sets
        // Example: storing user credentials for data-driven tests
        Map<String, String> testData = new HashMap<>();
        testData.put("username", "tomsmith");
        testData.put("password", "SuperSecretPassword!");

        String username = testData.get("username"); // "tomsmith"
        boolean hasKey = testData.containsKey("password"); // true
        int size = testData.size(); // 2
    }

    // =====================================================================
    // 7. METHODS — building reusable actions
    // =====================================================================

    // void = returns nothing
    public void clickButton(String buttonName) {
        System.out.println("Clicking: " + buttonName);
    }

    // String = returns a String value
    public String getPageTitle() {
        return "Login Page";
    }

    // boolean = returns true or false — used in assertions
    public boolean isElementVisible(String elementName) {
        return true;
    }

    // Method with multiple parameters
    public void login(String username, String password) {
        System.out.println("Logging in as: " + username);
    }

    // =====================================================================
    // 8. EXCEPTION HANDLING — used in waits and utilities
    // =====================================================================
    public void exceptionHandlingExample() {

        try {
            // Code that might fail
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Handle the specific error
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Always runs - like driver.quit() in tearDown
            System.out.println("This always runs");
        }

        // In automation used like this:
        // try {
        //     driver.findElement(By.id("element"));
        // } catch (NoSuchElementException e) {
        //     log.error("Element not found: " + e.getMessage());
        // }
    }

    // =====================================================================
    // 9. OOP CONCEPTS USED IN AUTOMATION
    // =====================================================================

    // INHERITANCE — LoginTest extends BaseTest
    // BaseTest has setUp() and tearDown()
    // LoginTest inherits them without rewriting
    // LoginTest extends BaseTest { ... }

    // ENCAPSULATION — private locators in page objects
    // private By usernameField = By.id("username");
    // Only the page class can access its own locators
    // Tests access behaviour through public methods only

    // ABSTRACTION — hiding complexity behind simple methods
    // Instead of: driver.findElement(By.id("username")).sendKeys("tom");
    // We expose: loginPage.enterUsername("tom");
    // The test doesn't know HOW it's done, just WHAT it does

    // POLYMORPHISM — method overloading
    // Same method name, different parameters
    public void selectOption(String text) {
        System.out.println("Select by text: " + text);
    }

    public void selectOption(int index) {
        System.out.println("Select by index: " + index);
    }
}
