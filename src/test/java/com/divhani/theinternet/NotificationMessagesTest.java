package com.divhani.theinternet;

import com.divhani.base.BaseTest;
import com.divhani.pages.NotificationMessagesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessagesTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(NotificationMessagesTest.class);
    NotificationMessagesPage notificationPage;

    @Test
    public void notificationAppearsAfterClickTest() {
        log.info("Starting notificationAppearsAfterClickTest");
        notificationPage = new NotificationMessagesPage(driver);

        notificationPage.navigateTo();
        notificationPage.clickHere();

        Assert.assertTrue(notificationPage.isNotificationDisplayed(),
                "Notification message should be displayed");
        log.info("notificationAppearsAfterClickTest passed");
    }

    @Test
    public void notificationIsOneOfExpectedMessagesTest() {
        log.info("Starting notificationIsOneOfExpectedMessagesTest");
        notificationPage = new NotificationMessagesPage(driver);

        notificationPage.navigateTo();
        notificationPage.clickHere();

        String message = notificationPage.getNotificationMessage();

        // Message is random - could be any of these
        // We use contains to handle the close button text included in getText()
        boolean isValidMessage = message.contains("Action successful") ||
                message.contains("Action unsuccesful") ||
                message.contains("Action unsuccessful");

        Assert.assertTrue(isValidMessage,
                "Message should be one of the expected notifications but was: " + message);
        log.info("notificationIsOneOfExpectedMessagesTest passed");
    }
}