package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class LaunchApp extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(LaunchApp.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void LaunchAppTest()
    {
        logger.info("********** Starting Test : LaunchAppTest **********");
        try
        {
            logger.debug("Initializing Home Page object...");
            HomePage hp = new HomePage(driver);

            logger.debug("Verifying Home Page title/text...");
            String homePage = hp.verifyHomePage();

            logger.debug("Expected Text : Enter name here");
            logger.debug("Actual Text   : {}", homePage);
            try
            {
                Assert.assertEquals(homePage, "Enter name here");
                logger.info("Home page verification passed.");
            }
            catch (AssertionError ae)
            {
                logger.error("Home page verification failed.", ae);
                captureScreen("LaunchAppTest");
                // Rethrow so TestNG marks the test as failed
                // and RetryAnalyzer can retry it.
                throw ae;
            }
            logger.info("********** LaunchAppTest PASSED **********");
        }
        catch (Exception e)
        {
            logger.error("Exception occurred while executing LaunchAppTest.", e);
            captureScreen("LaunchAppTest");
            throw e;
        }
        finally
        {
            logger.debug("LaunchAppTest execution completed.");
        }
    }
}