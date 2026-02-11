package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import utilities.CommonFlows;

public class TC007_CartTotalCalculationTest extends CommonFlows{
	@BeforeMethod
	public void applicationLogin()
	{
		login();
		searchProduct();
		addProductToCart();
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void verifyCartTotalCalculations()
	{
		CartPage cp=new CartPage(driver);
		cp.enterProductQuantity(p.getProperty("productQuantity"));
		cp.updateProductQuantity();
		Assert.assertEquals(cp.expPriceTotal(p.getProperty("productQuantity")), cp.actCartPriceTotal());
	}
	
	@AfterMethod
	public void applicationTesrdown()
	{
		logout();
	}
}
