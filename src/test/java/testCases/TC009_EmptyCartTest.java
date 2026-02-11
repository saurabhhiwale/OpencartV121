package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CartPage;
import utilities.CommonFlows;

public class TC009_EmptyCartTest extends CommonFlows{
	
	@BeforeMethod
	public void setup()
	{
		login();
	}
	
	@Test(groups= {"Regression"})
	public void verifyEmptyCartyFunctionality()
	{
		AddToCartPage atc=new AddToCartPage(driver);
		atc.navigateToShoppingCart();
		CartPage cp=new CartPage(driver);
		Assert.assertTrue(
		        cp.getProductDeletedMsg()
		          .contains(cp.getExpectedEmptyCartMessage()),
		        "❌ Empty cart message not displayed correctly"
		    );
	}
	
	@AfterMethod
	public void teardown()
	{
		logout();
	}

}
