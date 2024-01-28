package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class RegisterTestCase extends BaseClass {
	
	//public WebDriver driver;
	@Test(groups= {"sanity","master"})
	public void verify_register() throws InterruptedException
	{
		logger.info("***** Starting test ******");
		//Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		hp.clickregister();
		logger.info("clicked on home register");
		//String act=hp.checktextmsg();
		//System.out.println(act);
		logger.info("entering register details");
		RegisterPage rp=new RegisterPage(driver);
		rp.setusername(randomstring());
		rp.setlastname(randomnumeric());
		rp.setemail(randomstring()+"@gmail.com");
		String pwd=alphanumeric();
		rp.setpassword(pwd);
		rp.setconfirmpassword(pwd);
		rp.clickregister();
		logger.info("clicked on register page");
		logger.info("Test finished");
		
		//Assert.assertEquals(act,"Your registration completed");
		
	}

}
