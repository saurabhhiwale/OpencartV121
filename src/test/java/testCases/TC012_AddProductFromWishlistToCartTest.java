package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.MyWishlistPage;
import utilities.CommonFlows;

public class TC012_AddProductFromWishlistToCartTest extends CommonFlows{
	
	@BeforeMethod
	public void setup()
	{
		login();
		searchProduct();
	}
	
	@Test(groups= {"Sanity","Regression"})
	public void testAddProductToCartFromWishlistFunctionality()
	{
		MyWishlistPage wl=new MyWishlistPage(driver);
		wl.addProductToWishlist();
		wl.navigateToMyWishlist();
		wl.addToCartFromWishlist();
		Assert.assertTrue(wl.sucessMsgForWishlist());
	}

	@AfterMethod
	public void teardown()
	{
		logout();
	}
}
