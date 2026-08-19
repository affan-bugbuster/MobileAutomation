package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage 
{
	// constructor
	// HomePage is a subclass of BasePage.
	// When a HomePage object is created, it needs a WebDriver instance to work with.
	// super(driver); is a call to the constructor of the parent class (BasePage), passing along the WebDriver.
	
	public HomePage (AndroidDriver driver)
	{
		super(driver);
	}
	
	// Locators
	// Link - Enter Name
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	WebElement nameField;
	
	// Button - Lets Shop
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	WebElement letsShopButton;
	
	//Country - Dropdown
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	WebElement countryDropdown;
	
	//Toast Message
	@AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
	WebElement getToastMsg;
	
	// Action Methods
	public void enterName ()
	{
		nameField.sendKeys("Affan");
	}
	
	public void Click_LetsShop() throws InterruptedException
	{
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(letsShopButton));
		letsShopButton.click();
	}
	
	public void clickCountryDropdown()
	{
		countryDropdown.click();
	}
	
	public String verifyHomePage() 
	{
		return nameField.getText();
	}
	
	public String getToastMsg()
	{
		return getToastMsg.getAttribute("name");
	}	
}
