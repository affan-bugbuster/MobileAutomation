package pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage
{
	AndroidDriver driver;
	
	public BasePage (AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}	
	
	public void scrollToText(String text) 
	{
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true))" + ".scrollTextIntoView(\"" + text + "\")"));
	}
	
	public void scrollToTextAndClick(String text) 
	{
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true))" + ".scrollTextIntoView(\"" + text + "\")"));

		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + text + "\")")).click();
	}

	// Press Android back button
	public void pressBack() 
	{
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	// Switch context (NATIVE_APP / WEBVIEW)
	public void switchContext(String context) 
	{
		driver.context(context);
	}
}