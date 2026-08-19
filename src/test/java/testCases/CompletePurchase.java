package testCases;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.FinalPurchasePage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class CompletePurchase extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(CompletePurchase.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void CompletePurchaseTest() throws MalformedURLException, URISyntaxException, InterruptedException
    {
        logger.info("********** Starting Test : CompletePurchaseTest **********");

        try
        {
            logger.debug("Launching Home Page...");
            HomePage hp = new HomePage(driver);

            logger.debug("Entering user name...");
            hp.enterName();

            logger.debug("Clicking 'Let's Shop' button...");
            hp.Click_LetsShop();

            logger.info("Successfully navigated to Product Page.");
            ProductPage pp = new ProductPage(driver);

            logger.debug("Scrolling to product: Jordan 6 Rings");
            pp.scrollToText("Jordan 6 Rings");

            logger.debug("Adding product to cart...");
            pp.clickAddToCart();

            logger.debug("Opening Cart...");
            pp.viewCart();

            logger.info("Product added to cart successfully.");
            CartPage cp = new CartPage(driver);

            logger.debug("Selecting Terms and Conditions checkbox...");
            cp.clickCheckbox();

            logger.debug("Clicking 'Visit to Website' button...");
            cp.clickVisitToWeb();

            logger.info("Waiting for WEBVIEW context...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(drv -> driver.getContextHandles().size() > 1);

            logger.debug("WEBVIEW context is now available.");
            FinalPurchasePage fpp = new FinalPurchasePage(driver);

            logger.debug("Available Contexts:");
            Set<String> contexts = driver.getContextHandles();

            for (String contextName : contexts)
            {
                logger.debug("Context -> {}", contextName);
            }

            logger.info("Switching to WEBVIEW context...");
            fpp.switchContext("WEBVIEW_com.androidsample.generalstore");

            logger.debug("Entering search text...");
            fpp.setText();

            logger.debug("Pressing Android Back button...");
            fpp.pressBack();

            logger.info("Switching back to Native App...");
            fpp.switchContext("NATIVE_APP");

            logger.debug("Verifying Home Page...");
            String homePage = hp.verifyHomePage();

            logger.debug("Expected Text : Enter name here");
            logger.debug("Actual Text   : {}", homePage);

            try
            {
                Assert.assertEquals(homePage, "Enter name here");
                logger.info("Home page validation successful.");
            }
            catch (AssertionError ae)
            {
                logger.error("Home page validation failed.", ae);
                captureScreen("CompletePurchaseTest");
                throw ae;
            }
            logger.info("********** CompletePurchaseTest PASSED **********");
        }
        catch (Exception e)
        {
            logger.error("Exception occurred while executing CompletePurchaseTest.", e);
            captureScreen("CompletePurchaseTest");
            throw e;
        }
        finally
        {
            logger.debug("CompletePurchaseTest execution completed.");
        }
    }
}