package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import utilities.CommonFlows;

public class TC008_RemoveProductFromcartTest extends CommonFlows{
	
	@BeforeMethod
	public void setup()
	{
		login();
		searchProduct();
		addProductToCart();
	}
	
	@Test(groups= {"Sanity","Regression"})
	public void verifyRemoveProductFromCartFunctionality()
	{
		CartPage cp=new CartPage(driver);
		cp.removeProductFromCart();
		Assert.assertTrue(
			cp.getProductDeletedMsg()
				.contains(cp.getExpectedEmptyCartMessage())
			);	
		
		Assert.assertFalse(cp.isCartTableDisplayed(), "❌ Cart table still visible");

	}
	
	@AfterMethod
	public void teardown()
	{
		logout();
	}

}
