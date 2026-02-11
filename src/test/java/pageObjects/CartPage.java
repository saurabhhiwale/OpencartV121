package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement updateQuantityBtn;
	
	@FindBy(xpath="//i[@class='fa fa-check-circle']")
	private WebElement sucessMsg;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr//td[6]")
	private WebElement totalPrice;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr//td[5]")
	private WebElement unitPrice;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement removeProductBtn;
	
	@FindBy(xpath="(//p[contains(text(),'Your shopping cart is empty!')])[2]")
	private WebElement emptycartMsg;
	
	public void enterProductQuantity(String num)
	{	
		 WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'quantity')]")));
		 quantityInput.clear();
		 quantityInput.sendKeys(num);
	}
	
	public void updateProductQuantity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(updateQuantityBtn)).click();
	}
	
	public boolean validateSucessMsg()
	{	
		return sucessMsg.isDisplayed();
	}
	
	public double getUnitPriceFromCart()
	{
	    return Double.parseDouble(
	        unitPrice.getText().replaceAll("[^0-9.]", "")
	    );
	}
	
	public double expPriceTotal(String productquantity)
	{
		int quantity=Integer.parseInt(productquantity);
		
		return getUnitPriceFromCart()*quantity;
	}
	
	public double actCartPriceTotal()
	{
		String priceText = totalPrice.getText();
	    return Double.parseDouble(
	            priceText.replaceAll("[^0-9.]", "")
	    );
	}
	
	public void removeProductFromCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(removeProductBtn));
		removeProductBtn.click();
	}
	
	public String getProductDeletedMsg()
	{
		return emptycartMsg.getText();
	}
	
	public String getExpectedEmptyCartMessage()
	{
		return "Your shopping cart is empty!";
	}
	
	public boolean isCartTableDisplayed()
	{
	    return driver.findElements(
	        By.xpath("//table[@class='table table-bordered']")
	    ).size() > 0;
	}


}
