package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']") 
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement lnkLogin;
	
	public void clickMyAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount));
		lnkMyaccount.click();
	};
	
	public void clickLnkRegister() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkRegister));
		lnkRegister.click();
	}
	
	public void clickLnkLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogin));
		lnkLogin.click();
	}

}
