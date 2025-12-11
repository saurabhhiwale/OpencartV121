package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		lnkMyaccount.click();
	};
	
	public void clickLnkRegister() {
		lnkRegister.click();
	}
	
	public void clickLnkLogin() {
		lnkLogin.click();
	}

}
