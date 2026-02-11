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
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
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
		 WebElement quantityInput = driver.findElement(
			        By.xpath("//input[contains(@name,'quantity')]")
			    );
		 quantityInput.clear();
		 quantityInput.sendKeys(num);
	}
	
	public void updateProductQuantity()
	{
		wait.until(ExpectedConditions.elementToBeClickable(updateQuantityBtn)).click();
	}
	
	public boolean validateSucessMsg()
	{
		String act_msg=sucessMsg.getText();
		String exp_msg="Success: You have modified your shopping cart!";
		
		return act_msg.contains(exp_msg);
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
