package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CompareProductPage;
import utilities.CommonFlows;

public class TC016_CompareProductTest extends CommonFlows{
	@BeforeMethod
	public void setup()
	{
		login();
		searchProduct();
	}

	@Test(groups= {"Regression"})
	public void testCompareProductfunctionality()
	{
		CompareProductPage cp=new CompareProductPage(driver);
		cp.clickOnCompareProductBtn();
		Assert.assertTrue(cp.successMsgStatus());
	}
}
