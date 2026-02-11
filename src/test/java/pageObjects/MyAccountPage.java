package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage
{
	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public boolean isMyAccountExist() {
		try
		{
		return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}	
	
	public void clickLogout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));
		lnkLogout.click();
	}
	
}
