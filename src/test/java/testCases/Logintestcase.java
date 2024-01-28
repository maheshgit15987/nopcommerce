package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccount;
import testBase.BaseClass;

public class Logintestcase extends BaseClass{
	
	//public WebDriver driver;
	@Test(priority=1,groups= {"regression","master"})
	public void verifylogin()
	{
	
		logger.info("Started login testcase");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickloginlink();
		logger.info("clicked on login link");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(rb.getString("username"));
		lp.setpassword(rb.getString("pwd"));
		logger.info("provider details");
		lp.clicklogin();
		logger.info("clicked on login button");
		logger.info("finished test");
		Myaccount ma=new Myaccount(driver);
		boolean status=ma.checklogo();
		if(status==true)
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		}catch(Exception e)
		{
			Assert.fail();
		}
	}

}
