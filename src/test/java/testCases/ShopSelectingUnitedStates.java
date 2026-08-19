package testCases;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class ShopSelectingUnitedStates extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(ShopSelectingUnitedStates.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void LetsShopTest() throws MalformedURLException, URISyntaxException, InterruptedException
    {
        logger.info("********** Starting Test : LetsShopTest **********");
        try
        {
            logger.debug("Initializing Home Page object...");
            HomePage hp = new HomePage(driver);

            logger.debug("Selecting country: United States");
            hp.scrollToTextAndClick("United States");
            logger.info("Country selected successfully.");

            logger.debug("Entering user name...");
            hp.enterName();
            logger.info("User name entered successfully.");

            logger.debug("Clicking 'Let's Shop' button...");
            hp.Click_LetsShop();
            logger.info("Successfully navigated to Product Page.");

            logger.debug("Initializing Product Page object...");
            ProductPage pp = new ProductPage(driver);

            logger.debug("Retrieving Product Page title...");
            String products = pp.getProductPageTitle();

            logger.debug("Expected Title : Products");
            logger.debug("Actual Title   : {}", products);
            try
            {
                Assert.assertEquals(products, "Products");
                logger.info("Product Page validation successful.");
            }
            catch (AssertionError ae)
            {
                logger.error("Product Page validation failed.", ae);
                captureScreen("LetsShopTest");
                // Rethrow so RetryAnalyzer can retry the test
                throw ae;
            }
            logger.info("********** LetsShopTest PASSED **********");
        }
        catch (Exception e)
        {
            logger.error("Exception occurred while executing LetsShopTest.", e);
            captureScreen("LetsShopTest");
            throw e;
        }
        finally
        {
            logger.debug("LetsShopTest execution completed.");
        }
    }
}