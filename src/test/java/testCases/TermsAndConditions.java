package testCases;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TermsAndConditions extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(TermsAndConditions.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void AddToCartTest() throws MalformedURLException, URISyntaxException, InterruptedException
    {
        logger.info("********** Starting Test : AddToCartTest **********");
        try
        {
            logger.debug("Initializing Home Page object...");
            HomePage hp = new HomePage(driver);

            logger.debug("Entering user name...");
            hp.enterName();
            logger.info("User name entered successfully.");

            logger.debug("Clicking 'Let's Shop' button...");
            hp.Click_LetsShop();
            logger.info("Successfully navigated to Product Page.");

            ProductPage pp = new ProductPage(driver);
            logger.debug("Scrolling to product: Jordan 6 Rings");
            pp.scrollToText("Jordan 6 Rings");

            logger.debug("Adding product to cart...");
            pp.clickAddToCart();
            logger.info("Product added to cart successfully.");

            logger.debug("Opening Cart page...");
            pp.viewCart();

            CartPage cp = new CartPage(driver);

            logger.debug("Performing long press on Terms and Conditions button...");
            cp.longClickTermsButton();

            logger.debug("Retrieving Terms and Conditions dialog title...");
            String tAndC = cp.getAlertTitle();

            logger.debug("Expected Title : Terms Of Conditions");
            logger.debug("Actual Title   : {}", tAndC);

            try
            {
                Assert.assertEquals(tAndC, "Terms Of Conditions");
                logger.info("Terms and Conditions dialog validation successful.");
            }
            catch (AssertionError ae)
            {
                logger.error("Terms and Conditions dialog validation failed.", ae);
                captureScreen("AddToCartTest");
                // Rethrow so TestNG marks the test as failed
                // and RetryAnalyzer can retry it.
                throw ae;
            }
            logger.info("********** AddToCartTest PASSED **********");
        }
        catch (Exception e)
        {
            logger.error("Exception occurred while executing AddToCartTest.", e);
            captureScreen("AddToCartTest");
            throw e;
        }
        finally
        {
            logger.debug("AddToCartTest execution completed.");
        }
    }
}