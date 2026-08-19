package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);

    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result)
    {
        logger.debug("Checking retry eligibility for test: {}", result.getName());

        if (retryCount < maxRetryCount)
        {
            retryCount++;

            logger.warn(
                "Retry {} of {} for test '{}'",
                retryCount,
                maxRetryCount,
                result.getName());

            return true;
        }

        logger.error("Maximum retry attempts ({}) reached for test '{}'.", maxRetryCount, result.getName());

        return false;
    }
}