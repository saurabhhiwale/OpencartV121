package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.MyWishlistPage;
import utilities.CommonFlows;

public class TC014_EmptyWishlistTest extends CommonFlows{
	
	@BeforeMethod
	public void setUp()
	{
		login();
	}
	
	@Test(groups= {"Regression"})
	public void testEmptyCartFunctionality()
	{
		MyWishlistPage wl=new MyWishlistPage(driver);
		wl.navigateToMyWishlist();
		Assert.assertTrue(wl.validateEmptyCartMsg());
	}
	
	@AfterMethod
	public void teardown()
	{
		logout();
	}

}
