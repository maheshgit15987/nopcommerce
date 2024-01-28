package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
//import pageObjects.MyAccountPage;
import pageObjects.Myaccount;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
		//Home page
			HomePage hp=new HomePage(driver);
			hp.clickloginlink();
			
				
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.setusername(email);
			lp.setpassword(password);
			lp.clicklogin();
			
				
			//My Account Page
			Myaccount macc=new Myaccount(driver);
			boolean targetPage=macc.checklogo();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








