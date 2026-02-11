package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductPage extends BasePage{

	public CompareProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@data-original-title='Compare this Product']")
	private WebElement compareProductBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMsg;
	
	public void clickOnCompareProductBtn()
	{
		compareProductBtn.click();
	}
	
	public boolean successMsgStatus()
	{
		return successMsg.isDisplayed();
	}

}
