package utilities;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class CommonFlows extends BaseClass{
	
	public void login()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLnkLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
	}
	
	public void searchProduct()
	{
		SearchProductPage sp=new SearchProductPage(driver);
		sp.searchProduct(p.getProperty("searchProductName"));
		sp.selectCategory();
		sp.searchInSubcategory();
		sp.searchInProductDescription();
		sp.clickOnSearchBtn();
		sp.sortByPrice();
	}
	
	public AddToCartPage addProductToCart()
	{
		AddToCartPage atc=new AddToCartPage(driver);
		atc.clickOnaddtocartBtn();
		atc.navigateToShoppingCart();
		return atc;
	}
	
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		MyAccountPage acc=new MyAccountPage(driver);
		acc.clickLogout();
	}

}
