package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyWishlistPage extends BasePage{

	public MyWishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//i[@class='fa fa-heart'])[2]")
	private WebElement addToWishlistBtn;
	
	@FindBy(xpath="(//i[@class='fa fa-heart'])[1]")
	private WebElement myWishlistlink;
	
	@FindBy(xpath="//tbody//tr//td[2]")
	private WebElement productNameInMyWishlist;
	
	@FindBy(xpath="//tbody//tr//td[5]")
	private WebElement productPriceInMyWishlist;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMsg;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement wishlistAddToCartBtn;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement removeFromMyWishlistBtn;
	
	@FindBy(xpath="//p[normalize-space()='Your wish list is empty.']")
	private WebElement emptyCartMsg;
	
	public void addProductToWishlist()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addToWishlistBtn)).click();;
	}
	
	public void navigateToMyWishlist()
	{
		WebElement wishlistlnk=wait.until(ExpectedConditions.elementToBeClickable(myWishlistlink));
		wishlistlnk.click();
	}
	
	public String getProductNameFromWishlist()
	{
		return wait.until(ExpectedConditions.visibilityOf(productNameInMyWishlist)).getText();
	}
	
	public String getProductPriceFromMyWishlist()
	{
		return wait.until(ExpectedConditions.visibilityOf(productPriceInMyWishlist)).getText();
	}
		
	public boolean sucessMsgForWishlist()
	{
		return successMsg.isDisplayed();
	}
	
	public void addToCartFromWishlist()
	{
		wishlistAddToCartBtn.click();
	}
	
	public void removeProductFromWishlist()
	{
		removeFromMyWishlistBtn.click();
	}
	
	public boolean validateEmptyCartMsg()
	{
		return emptyCartMsg.isDisplayed();
	}

}
