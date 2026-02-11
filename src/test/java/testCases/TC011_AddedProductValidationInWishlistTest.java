package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.MyWishlistPage;
import utilities.CommonFlows;

public class TC011_AddedProductValidationInWishlistTest extends CommonFlows{
	@BeforeMethod
	public void setup()
	{
		login();
		searchProduct();
	}
	
	@Test(groups= {"Regression"})
	public void validateAddedProductInWishlist() throws InterruptedException
	{
		AddToCartPage atc=new AddToCartPage(driver);
		String prodName=atc.getActProductName();
		String prodPrice=atc.getActProductPrice();
		MyWishlistPage wl=new MyWishlistPage(driver);
		wl.addProductToWishlist();
		wl.navigateToMyWishlist();
		
		Assert.assertEquals(wl.getProductNameFromWishlist(), prodName);
		Assert.assertEquals(wl.getProductPriceFromMyWishlist(), prodPrice);
	}
	
	@AfterMethod
	public void teardown()
	{
		logout();
	} 

}
