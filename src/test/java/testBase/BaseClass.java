package testBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass
{
    public AndroidDriver driver;

    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeClass
    @Parameters({"deviceName", "systemPort"})
    public void ConfigureAppium(String dn, String sysPort)
            throws MalformedURLException, URISyntaxException
    {
        logger.info("========== Appium Test Execution Started ==========");
        logger.debug("Device Name : {}", dn);
        logger.debug("System Port : {}", sysPort);

        try
        {
            logger.info("Configuring UiAutomator2 Options...");

            UiAutomator2Options options = new UiAutomator2Options();

            options.setSystemPort(Integer.parseInt(sysPort));
            options.setDeviceName(dn);
            options.setApp("C:\\Workspaces\\QA bootcamp\\MobileV3\\resources\\General-Store.apk");
            options.setChromedriverExecutable("D:\\QA Automation\\Tools\\chromedriver-win64\\chromedriver.exe");

            logger.debug("Launching Android Driver...");

            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);

            logger.debug("Setting implicit wait to 10 seconds...");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            logger.info("Android Driver initialized successfully.");
        }
        catch (NumberFormatException e)
        {
            logger.error("Invalid System Port value: {}", sysPort, e);
            throw e;
        }
        catch (MalformedURLException e)
        {
            logger.error("Malformed Appium Server URL.", e);
            throw e;
        }
        catch (URISyntaxException e)
        {
            logger.error("Invalid Appium Server URI.", e);
            throw e;
        }
        catch (Exception e)
        {
            logger.error("Unexpected exception occurred while initializing Appium.", e);
            throw new RuntimeException("Appium initialization failed.", e);
        }
    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Closing Android Driver...");

        try
        {
            if (driver != null)
            {
                driver.quit();
                logger.info("Android Driver closed successfully.");
            }
            else
            {
                logger.warn("Driver instance is null. Nothing to close.");
            }
        }
        catch (Exception e)
        {
            logger.error("Error while closing Android Driver.", e);
        }

        logger.info("========== Test Execution Finished ==========");
    }

    public String captureScreen(String tname)
    {
        logger.debug("Capturing screenshot for test: {}", tname);

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        try
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);

            String targetFilePath = System.getProperty("user.dir")
                    + "\\screenshots\\"
                    + tname + "_"
                    + timeStamp + ".png";

            File targetFile = new File(targetFilePath);
            sourceFile.renameTo(targetFile);

            logger.info("Screenshot captured successfully.");
            logger.debug("Screenshot saved at: {}", targetFilePath);

            return targetFilePath;
        }
        catch (Exception e)
        {
            logger.error("Failed to capture screenshot for test: {}", tname, e);
            return null;
        }
    }
}