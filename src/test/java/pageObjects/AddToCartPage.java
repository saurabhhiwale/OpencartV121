package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCartPage extends BasePage{

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//div[@class='button-group']//button)[1]")
	private WebElement addtocartBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMsg;
	
	@FindBy(xpath="//a[@title='Shopping Cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//div[@class='caption']//h4")
	private WebElement actProductName;
	
	@FindBy(xpath="(//table[@class='table table-bordered']//tbody//tr//td[2])[5]")
	private WebElement productNameFromCart;
	
	@FindBy(xpath="//p[@class='price']")
	private WebElement actProductPrice;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr//td[5]")
	private WebElement productPriceFromCart;
	
	public void clickOnaddtocartBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addtocartBtn));
		addtocartBtn.click();
	}
	
	public boolean validateSuccessMsg()
	{
		return successMsg.isDisplayed();
	}
	
	public void navigateToShoppingCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
		shoppingCart.click();
	}
	
	public String getActProductName()
	{
		wait.until(ExpectedConditions.visibilityOf(actProductName));
		return actProductName.getText();
	}
	
	public String getProductNameFromCart()
	{
		wait.until(ExpectedConditions.visibilityOf(productNameFromCart));
		return productNameFromCart
				.getText()
				.trim();
	}
	
	public String getActProductPrice() {
		wait.until(ExpectedConditions.visibilityOf(actProductPrice));
	    return actProductPrice
	            .getText()
	            .split("\n")[0]
	            .trim();
	}
	
	public String getProductPriceFromCart()
	{
		wait.until(ExpectedConditions.visibilityOf(productPriceFromCart));
		return productPriceFromCart.getText();
	}
	
	

}
