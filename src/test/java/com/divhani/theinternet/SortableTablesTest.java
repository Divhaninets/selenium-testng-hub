package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.SortableTablesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SortableTablesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(SortableTablesTest.class);
    SortableTablesPage tablesPage;

    @Test
    public void tableRowCountTest() {
        log.info("Starting tableRowCountTest");
        tablesPage = new SortableTablesPage(driver);

        tablesPage.navigateTo();

        Assert.assertEquals(tablesPage.getTable1RowCount(), 4,
                "Table 1 should have 4 rows");
        log.info("tableRowCountTest passed");
    }

    @Test
    public void getSpecificCellValueTest() {
        log.info("Starting getSpecificCellValueTest");
        tablesPage = new SortableTablesPage(driver);

        tablesPage.navigateTo();

        // Row 0, Column 0 = Last Name of first row = Smith
        String cellValue = tablesPage.getTable1CellValue(0, 0);
        Assert.assertEquals(cellValue, "Smith",
                "First row last name should be Smith");
        log.info("getSpecificCellValueTest passed");
    }

    @Test
    public void getDueAmountByLastNameTest() {
        log.info("Starting getDueAmountByLastNameTest");
        tablesPage = new SortableTablesPage(driver);

        tablesPage.navigateTo();

        String due = tablesPage.getDueAmountByLastName("Bach");
        Assert.assertEquals(due, "$51.00",
                "Bach's due amount should be $51.00");
        log.info("getDueAmountByLastNameTest passed");
    }

    @Test
    public void getAllEmailsTest() {
        log.info("Starting getAllEmailsTest");
        tablesPage = new SortableTablesPage(driver);

        tablesPage.navigateTo();

        // Column index 2 = Email column
        List<String> emails = tablesPage.getTable1ColumnValues(2);
        Assert.assertEquals(emails.size(), 4,
                "Should have 4 emails");
        Assert.assertTrue(emails.contains("jsmith@gmail.com"),
                "Should contain jsmith@gmail.com");
        log.info("getAllEmailsTest passed");
    }
}
