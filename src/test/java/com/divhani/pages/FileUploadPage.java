package com.divhani.pages;

import com.divhani.utils.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(FileUploadPage.class);

    // Locators
    private By fileInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFileName = By.id("uploaded-files");
    private By successHeader = By.tagName("h3");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/upload");
        log.info("Navigated to File Upload page");
    }

    // Upload a file using sendKeys - no OS dialog needed
    // Pass the FULL file path as a string
    public void uploadFile(String filePath) {
        WaitUtil.waitForVisibility(driver, fileInput).sendKeys(filePath);
        log.info("File path entered: " + filePath);
    }

    public void clickUpload() {
        WaitUtil.waitForClickability(driver, uploadButton).click();
        log.info("Clicked Upload button");
    }

    public String getUploadedFileName() {
        WaitUtil.waitForVisibility(driver, uploadedFileName);
        String fileName = driver.findElement(uploadedFileName).getText();
        log.info("Uploaded file name shown: " + fileName);
        return fileName;
    }

    public String getSuccessHeader() {
        WaitUtil.waitForVisibility(driver, successHeader);
        String header = driver.findElement(successHeader).getText();
        log.info("Success header: " + header);
        return header;
    }

    // Combined action - upload file in one step
    public void uploadFileAndSubmit(String filePath) {
        uploadFile(filePath);
        clickUpload();
    }
}
