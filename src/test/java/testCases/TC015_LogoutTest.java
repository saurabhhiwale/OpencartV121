package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.CommonFlows;

public class TC015_LogoutTest extends CommonFlows{
	@BeforeMethod
	public void setup()
	{
		login();
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void testLogoutFunctionality()
	{
		logout();
	}

}
