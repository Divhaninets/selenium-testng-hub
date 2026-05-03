# Selenium TestNG Hub Framework

A comprehensive Selenium + TestNG automation framework built as a **personal knowledge hub** — covering all locator types, automation solutions, Java fundamentals, and framework best practices.

## Framework Overview

This is not just a test suite. It is an **automation bible** — a living reference library built to:
- Document every automation concept with working examples
- Store solutions for common automation challenges
- Serve as a go-to reference during interviews and daily work

## Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 17 (LTS) | Programming language |
| Selenium WebDriver | 4.20.0 | Browser automation |
| TestNG | 7.9.0 | Test framework |
| Maven | 3.x | Build and dependency management |
| ExtentReports | 5.1.1 | HTML test reports |
| Allure | 2.27.0 | Advanced reporting |
| Log4j2 | 2.23.1 | Logging |
| Apache Commons IO | 2.15.1 | File handling |

## Project Structure

## Framework Features

### Reports
- **ExtentReports** — HTML report generated after every test run
- **Allure** — Interactive dashboard with trends and history
- Reports saved to `test-output/` folder

### Screenshots
- Automatic screenshot on test failure
- Screenshots saved to `test-output/screenshots/`
- Attached directly to ExtentReport for easy debugging

### Logging
- **Log4j2** with two appenders:
    - Console — live output during test run
    - File — permanent log saved to `test-output/logs/`

### Waits
- Centralised explicit waits in `WaitUtil`
- All `ExpectedConditions` documented in `WaitsReference.java`

## Automation Solutions

### the-internet.herokuapp.com

| Page | Concept | Tests |
|------|---------|-------|
| Form Authentication | Login, assertions | 2 |
| Checkboxes | isSelected, check, uncheck | 3 |
| Dropdown | Select class — text, value, index | 3 |
| JavaScript Alerts | alert, confirm, prompt | 4 |
| Multiple Windows | window handles, switchTo | 3 |
| Frames & iFrames | switchTo frame, defaultContent | 3 |
| Drag and Drop | Actions class | 1 |
| File Upload | sendKeys with file path | 2 |
| Hovers | moveToElement | 3 |
| Dynamic Loading | Explicit waits in practice | 2 |
| Sortable Tables | Table traversal, cell values | 4 |
| Key Presses | Keys class | 3 |
| Context Menu | Right click, contextClick | 1 |
| Add/Remove Elements | Dynamic DOM | 4 |
| Broken Images | JavaScript execution | 3 |
| Notification Messages | Dynamic messages | 2 |
| Redirect Link | URL verification | 2 |
| Horizontal Slider | Arrow keys on range input | 2 |
| Geolocation | JavaScript geolocation mock | 2 |
| Infinite Scroll | JavaScript scroll execution | 2 |
| Shadow DOM | getShadowRoot() Selenium 4 | 2 |
| A/B Testing | Page variant verification | 1 |
| Status Codes | URL and content verification | 3 |
| Typos | Dynamic text content | 2 |
| Floating Menu | JavaScript scroll, fixed elements | 2 |
| Inputs | Number input, arrow key control | 3 |
| Key Presses | Keys class — TAB, ESCAPE, ARROW | 3 |
| Context Menu | Right click, contextClick() | 1 |
| Add/Remove Elements | Dynamic DOM manipulation | 4 |
| Broken Images | JavaScript naturalWidth check | 3 |
| Notification Messages | Dynamic flash messages | 2 |
| Redirect Link | URL verification after redirect | 2 |

## Reference Library

### Locators (`locators/`)
All 8 Selenium locator types documented with examples:
ID, Name, ClassName, TagName, LinkText, PartialLinkText, CSS Selector, XPath

### Java Notes (`java_notes/`)
- `JavaBasicsForAutomation.java` — Variables, strings, loops, collections, OOP
- `WaitsReference.java` — Implicit, explicit, fluent waits with all ExpectedConditions
- `PageObjectReference.java` — POM structure, naming conventions, interview Q&A

## Running the Tests

```bash
# Run all tests
mvn clean test

# Run specific suite
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
```

## Reports

After running tests, open:
- `test-output/ExtentReport.html` — HTML test report
- `test-output/logs/test-execution.log` — Execution log

## Author

**Divhani Netshiombo**
GitHub: [Divhaninets](https://github.com/Divhaninets)

## Project Structure

```
selenium-testng-hub/
├── src/
│   ├── main/java/com/divhani/
│   │   ├── locators/          # All 8 locator types documented
│   │   ├── utils/             # Reusable helpers (WaitUtil)
│   │   └── java_notes/        # Java fundamentals reference
│   └── test/
│       ├── java/com/divhani/
│       │   ├── base/          # BaseTest — driver setup & teardown
│       │   ├── pages/         # Page Object classes
│       │   ├── theinternet/   # Tests for the-internet.herokuapp.com
│       │   ├── demoqa/        # Tests for demoqa.com
│       │   ├── uitestingplayground/ # Tests for uitestingplayground.com
│       │   └── utils/         # ExtentReportManager, ScreenshotUtil
│       ├── resources/
│       │   ├── testng.xml     # Test suite configuration
│       │   └── log4j2.xml     # Logging configuration
│       └── testdata/          # Test files for upload tests
└── pom.xml
```