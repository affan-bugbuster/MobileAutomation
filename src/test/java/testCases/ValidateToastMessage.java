package testCases;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class ValidateToastMessage extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(ValidateToastMessage.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void ValidateToastMessageTest() throws MalformedURLException, URISyntaxException, InterruptedException
    {
        logger.info("********** Starting Test : ValidateToastMessageTest **********");
        try
        {
            logger.debug("Initializing Home Page object...");
            HomePage hp = new HomePage(driver);

            logger.debug("Clicking 'Let's Shop' button without entering a name...");
            hp.Click_LetsShop();
            logger.info("Application displayed the validation toast.");

            logger.debug("Retrieving toast message...");
            String toastMessage = hp.getToastMsg();

            logger.debug("Expected Toast Message : Please enter your name");
            logger.debug("Actual Toast Message   : {}", toastMessage);

            try
            {
                Assert.assertEquals(toastMessage, "Please enter your name");
                logger.info("Toast message validation successful.");
            }
            catch (AssertionError ae)
            {
                logger.error("Toast message validation failed.", ae);
                captureScreen("ValidateToastMessageTest");
                // Rethrow so TestNG marks the test as failed
                // and RetryAnalyzer can retry the test.
                throw ae;
            }
            logger.info("********** ValidateToastMessageTest PASSED **********");
        }
        catch (Exception e)
        {
            logger.error("Exception occurred while executing ValidateToastMessageTest.", e);
            captureScreen("ValidateToastMessageTest");
            throw e;
        }
        finally
        {
            logger.debug("ValidateToastMessageTest execution completed.");
        }
    }
}