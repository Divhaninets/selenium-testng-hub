package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.FileUploadPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(FileUploadTest.class);
    FileUploadPage fileUploadPage;

    // Full path to our test file
    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\testdata\\testfile.txt";

    @Test
    public void uploadFileTest() {
        log.info("Starting uploadFileTest");
        fileUploadPage = new FileUploadPage(driver);

        fileUploadPage.navigateTo();
        fileUploadPage.uploadFileAndSubmit(FILE_PATH);

        // Verify success header appears
        Assert.assertEquals(fileUploadPage.getSuccessHeader(), "File Uploaded!",
                "Success header should appear after upload");
        log.info("uploadFileTest passed");
    }

    @Test
    public void uploadedFileNameIsCorrectTest() {
        log.info("Starting uploadedFileNameIsCorrectTest");
        fileUploadPage = new FileUploadPage(driver);

        fileUploadPage.navigateTo();
        fileUploadPage.uploadFileAndSubmit(FILE_PATH);

        // Verify the correct file name is displayed
        Assert.assertEquals(fileUploadPage.getUploadedFileName(), "testfile.txt",
                "Uploaded file name should match");
        log.info("uploadedFileNameIsCorrectTest passed");
    }
}
