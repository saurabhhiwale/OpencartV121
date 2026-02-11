package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass{
	@BeforeMethod
	public void applicationSetUp() {
		logger.info("***Starting TC_005 Add Product To Cart Test***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLnkLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductPage sp=new SearchProductPage(driver);
		sp.searchProduct(p.getProperty("searchProductName"));
		sp.selectCategory();
		sp.searchInSubcategory();
		sp.searchInProductDescription();
		sp.clickOnSearchBtn();
		System.out.println("search product clicked");
		sp.sortByPrice();
		System.out.println("sort product clicked");
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void verifyAddToCartFunctionality() throws InterruptedException
	{
		AddToCartPage atc=new AddToCartPage(driver);
		String actProductName=atc.getActProductName();
		String actProductPrice=atc.getActProductPrice();
		atc.clickOnaddtocartBtn();
		System.out.println("product added to cart");
		Assert.assertTrue(atc.validateSuccessMsg(),
				"❌ Add to cart success message was NOT displayed");
		atc.navigateToShoppingCart();

		Thread.sleep(2000);
		
		Assert.assertTrue(
				atc.getProductNameFromCart().startsWith(actProductName),
			    "❌ Product name mismatch between product page and cart"
			);

		Assert.assertEquals(actProductPrice, 
				atc.getProductPriceFromCart(),
				"❌ Product price mismatch between product page and cart");
	}
	
	@AfterMethod
	public void applicationLogout()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		MyAccountPage acc=new MyAccountPage(driver);
		acc.clickLogout();
	}

}
