package com.divhani.locators;

import org.openqa.selenium.By;

/**
 * LOCATOR TYPES REFERENCE GUIDE
 * ==============================
 * This class is your personal bible for all Selenium locator types.
 * It is NOT a test class - it is a REFERENCE LIBRARY.
 * Come here when you forget how to write a locator.
 *
 * The 8 locator types in Selenium:
 * 1. ID
 * 2. Name
 * 3. Class Name
 * 4. Tag Name
 * 5. Link Text
 * 6. Partial Link Text
 * 7. CSS Selector
 * 8. XPath
 */
public class LocatorTypesDemo {

    // =====================================================================
    // 1. ID LOCATOR
    // =====================================================================
    // Best locator when available - IDs are unique on a page by definition
    // Use when: the element has an id attribute
    // HTML example: <input id="username">
    By idLocator = By.id("username");

    // =====================================================================
    // 2. NAME LOCATOR
    // =====================================================================
    // Good for form elements - name attributes are common on inputs
    // Use when: the element has a name attribute
    // HTML example: <input name="email">
    By nameLocator = By.name("email");

    // =====================================================================
    // 3. CLASS NAME LOCATOR
    // =====================================================================
    // Use when: element has a unique class name
    // WARNING: If multiple elements share the same class, this finds the first one
    // HTML example: <button class="submit-btn">
    By classNameLocator = By.className("submit-btn");

    // =====================================================================
    // 4. TAG NAME LOCATOR
    // =====================================================================
    // Finds elements by their HTML tag
    // Use when: you want ALL elements of a type (e.g. all links, all buttons)
    // Rarely used for single elements - usually used with findElements (plural)
    // HTML example: <a href="..."> - finds all anchor tags
    By tagNameLocator = By.tagName("a");

    // =====================================================================
    // 5. LINK TEXT LOCATOR
    // =====================================================================
    // Only works on <a> anchor/link elements
    // Matches the EXACT visible text of the link
    // HTML example: <a href="/login">Sign In</a>
    By linkTextLocator = By.linkText("Sign In");

    // =====================================================================
    // 6. PARTIAL LINK TEXT LOCATOR
    // =====================================================================
    // Like Link Text but matches PART of the link text
    // Use when: link text is long or dynamic
    // HTML example: <a href="/login">Sign In To Your Account</a>
    By partialLinkTextLocator = By.partialLinkText("Sign In");

    // =====================================================================
    // 7. CSS SELECTOR
    // =====================================================================
    // Very powerful and fast - second most preferred after ID
    // Use when: no ID available, or you need complex selection

    // By ID:           #username          (same as By.id)
    // By Class:        .submit-btn        (same as By.className)
    // By Tag:          input              (same as By.tagName)
    // By Attribute:    input[type='text']
    // By Tag + Class:  button.submit-btn
    // Child element:   div > button       (direct child)
    // Descendant:      div button         (any level)
    // Nth child:       ul li:nth-child(2) (second list item)

    By cssById = By.cssSelector("#username");
    By cssByClass = By.cssSelector(".submit-btn");
    By cssByAttribute = By.cssSelector("input[type='submit']");
    By cssByTagAndClass = By.cssSelector("button.submit-btn");
    By cssByChild = By.cssSelector("div > button");
    By cssByNthChild = By.cssSelector("ul li:nth-child(2)");

    // =====================================================================
    // 8. XPATH
    // =====================================================================
    // Most powerful locator - can navigate the entire DOM tree
    // Use when: CSS selector is not enough, or you need text-based search

    // --- ABSOLUTE XPATH ---
    // Starts from root of the page - FRAGILE, avoid in real tests
    // Breaks if page structure changes
    By absoluteXpath = By.xpath("/html/body/div/form/input");

    // --- RELATIVE XPATH ---
    // Starts with // - searches anywhere in the DOM - PREFERRED
    By relativeXpath = By.xpath("//input[@id='username']");

    // --- XPATH WITH TEXT ---
    // Finds element by its visible text
    By xpathByText = By.xpath("//button[text()='Sign In']");

    // --- XPATH WITH CONTAINS ---
    // Partial text match - more flexible than exact text
    By xpathWithContains = By.xpath("//button[contains(text(),'Sign')]");

    // --- XPATH WITH CONTAINS ON ATTRIBUTE ---
    // Useful for dynamic class names or IDs
    By xpathContainsAttribute = By.xpath("//input[contains(@id,'user')]");

// --- XPATH
}