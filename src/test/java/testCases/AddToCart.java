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

public class AddToCart extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(AddToCart.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void AddToCartTest() throws MalformedURLException, URISyntaxException, InterruptedException
    {
        logger.info("********** Starting Test : AddToCartTest **********");

        try
        {
            logger.debug("Initializing Home Page...");
            HomePage hp = new HomePage(driver);

            logger.debug("Entering user name...");
            hp.enterName();

            logger.debug("Clicking 'Let's Shop' button...");
            hp.Click_LetsShop();

            logger.info("Successfully navigated to Product Page.");
            ProductPage pp = new ProductPage(driver);

            logger.debug("Scrolling to product : Jordan 6 Rings");
            pp.scrollToText("Jordan 6 Rings");

            logger.debug("Adding product to cart...");
            pp.clickAddToCart();

            logger.debug("Opening Cart page...");
            pp.viewCart();

            logger.info("Product added successfully.");
            CartPage cp = new CartPage(driver);

            logger.debug("Fetching product name from Cart...");
            String productInCart = cp.getAddedProductName();

            logger.debug("Expected Product : Jordan 6 Rings");
            logger.debug("Actual Product   : {}", productInCart);

            try
            {
                Assert.assertEquals(productInCart, "Jordan 6 Rings");
                logger.info("Product validation successful.");
            }
            catch (AssertionError ae)
            {
                logger.error("Assertion failed. Product validation unsuccessful.", ae);
                captureScreen("AddToCartTest");
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