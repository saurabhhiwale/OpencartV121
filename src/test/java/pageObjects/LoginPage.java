package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) 
	{
		wait.until(ExpectedConditions.visibilityOf(txtEmailAddress));
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}

}
