package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SortableTablesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(SortableTablesPage.class);

    // Table 1 locators - no class or ID on rows
    private By table1 = By.id("table1");
    private By table1Rows = By.cssSelector("#table1 tbody tr");
    private By table1Headers = By.cssSelector("#table1 thead th");

    // Table 2 locators - has class and ID attributes
    private By table2 = By.id("table2");
    private By table2Rows = By.cssSelector("#table2 tbody tr");

    // Column sort headers
    private By lastNameHeader = By.cssSelector("#table1 thead th:nth-child(1)");
    private By dueHeader = By.cssSelector("#table1 thead th:nth-child(4)");

    public SortableTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/tables");
        log.info("Navigated to Sortable Tables page");
    }

    // Get total number of rows in table 1
    public int getTable1RowCount() {
        int count = driver.findElements(table1Rows).size();
        log.info("Table 1 row count: " + count);
        return count;
    }

    // Get cell value by row and column index (0-based)
    public String getTable1CellValue(int rowIndex, int colIndex) {
        List<WebElement> rows = driver.findElements(table1Rows);
        List<WebElement> cells = rows.get(rowIndex).findElements(By.tagName("td"));
        String value = cells.get(colIndex).getText();
        log.info("Table 1 cell [" + rowIndex + "][" + colIndex + "]: " + value);
        return value;
    }

    // Get all values from a specific column
    public List<String> getTable1ColumnValues(int colIndex) {
        List<WebElement> rows = driver.findElements(table1Rows);
        List<String> values = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            values.add(cells.get(colIndex).getText());
        }
        log.info("Column " + colIndex + " values: " + values);
        return values;
    }

    // Find a row by last name and return the due amount
    public String getDueAmountByLastName(String lastName) {
        List<WebElement> rows = driver.findElements(table1Rows);
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals(lastName)) {
                String due = cells.get(3).getText();
                log.info("Due amount for " + lastName + ": " + due);
                return due;
            }
        }
        log.warn("Last name not found: " + lastName);
        return null;
    }

    // Click a column header to sort
    public void clickLastNameHeader() {
        WaitUtil.waitForClickability(driver, lastNameHeader).click();
        log.info("Clicked Last Name header to sort");
    }

    public void clickDueHeader() {
        WaitUtil.waitForClickability(driver, dueHeader).click();
        log.info("Clicked Due header to sort");
    }
}