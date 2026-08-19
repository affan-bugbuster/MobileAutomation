package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BasePage
{
	//constructor
	public CartPage (AndroidDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	// Checkbox
	@AndroidFindBy(className = "android.widget.CheckBox")
	WebElement checkBox;
	
	// Button to proceed to Web
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	WebElement btnToWeb;
	
	// Terms Button
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	WebElement termsButton;
	
	// Product Name in the cart
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	WebElement addedProductName;
	
	// Alert Text from Terms and Conditions
	@AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
	WebElement alertText;
	
	// Action Methods
	
	public void clickCheckbox()
	{
		checkBox.click();
	}
	
	public void clickVisitToWeb()
	{
		btnToWeb.click();
	}
	
	public void longClickTermsButton()
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) termsButton).getId()));
	}
	
	public String getAddedProductName() throws InterruptedException
	{
		Thread.sleep(1000);
		return addedProductName.getText();
	}
	
	public String getAlertTitle()
	{
		return alertText.getText();
	}
}