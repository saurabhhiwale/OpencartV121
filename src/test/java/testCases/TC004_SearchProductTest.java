package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass{
	
	@BeforeMethod
	public void applicationlogin() {
		logger.info("***Starting TC_004 Search-Product Test***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLnkLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void verifySearchProductFunctionality()
	{
		SearchProductPage sp=new SearchProductPage(driver);
		sp.searchProduct(p.getProperty("searchProductName"));
		sp.selectCategory();
		sp.searchInSubcategory();
		sp.searchInProductDescription();
		sp.clickOnSearchBtn();
		sp.sortByPrice();
		Assert.assertTrue(sp.isProductListPresent());
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
