package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDTtestcase extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	void verifyloginddt(String email,String pwd,String res)
	{
		logger.info("Started login testcase");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickloginlink();
		logger.info("clicked on login link");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(email);
		lp.setpassword(pwd);
		System.out.println(res);
		logger.info("provider details");
		lp.clicklogin();
		
		Myaccount ma=new Myaccount(driver);
		boolean status=ma.checklogo();
		
		logger.info("clicked on login button");
		logger.info("finished test");
		
		if(res.equalsIgnoreCase("Valid"))
		{
			if(status==true)
			{
				System.out.println("enter valid loop");
				ma.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				System.out.println("enter valid else loop");
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("Invalid"))
		{
			if(status==true)
			{
				System.out.println("enteres invalid loop");
				ma.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				System.out.println("enteres invalid  els loop");
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

