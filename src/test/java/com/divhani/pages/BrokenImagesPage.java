package com.divhani.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(BrokenImagesPage.class);

    private By allImages = By.tagName("img");

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        log.info("Navigated to Broken Images page");
    }

    // Get total number of images on the page
    public int getTotalImageCount() {
        int count = driver.findElements(allImages).size();
        log.info("Total images on page: " + count);
        return count;
    }

    // Check if an image is broken using JavaScript
    // naturalWidth = 0 means image failed to load
    public boolean isImageBroken(WebElement image) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object naturalWidth = js.executeScript(
                "return arguments[0].naturalWidth", image
        );
        boolean broken = naturalWidth.toString().equals("0");
        log.info("Image src: " + image.getAttribute("src") +
                " | Broken: " + broken);
        return broken;
    }

    // Get list of all broken image URLs
    public List<String> getBrokenImageUrls() {
        List<WebElement> images = driver.findElements(allImages);
        List<String> brokenUrls = new ArrayList<>();

        for (WebElement image : images) {
            if (isImageBroken(image)) {
                brokenUrls.add(image.getAttribute("src"));
            }
        }
        log.info("Broken image count: " + brokenUrls.size());
        return brokenUrls;
    }

    // Count how many images loaded successfully
    public int getValidImageCount() {
        List<WebElement> images = driver.findElements(allImages);
        int validCount = 0;
        for (WebElement image : images) {
            if (!isImageBroken(image)) {
                validCount++;
            }
        }
        log.info("Valid image count: " + validCount);
        return validCount;
    }
}
