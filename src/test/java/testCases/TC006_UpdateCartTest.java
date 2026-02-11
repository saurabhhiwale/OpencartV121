package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import utilities.CommonFlows;

public class TC006_UpdateCartTest extends CommonFlows{
	
	@BeforeMethod
	public void applicationSetup()
	{
		login();
		searchProduct();
		addProductToCart();
	}
	
	@Test(groups= {"Sanity","Regression"})
	public void verifyUpdateCartFunctionality()
	{

			CartPage cp=new CartPage(driver);
			cp.enterProductQuantity(p.getProperty("productQuantity"));
			cp.updateProductQuantity();
			Assert.assertTrue(cp.validateSucessMsg());

	}
	
	@AfterMethod
	public void applicationTeardown()
	{
		logout();
	}

}
