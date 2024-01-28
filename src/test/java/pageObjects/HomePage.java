package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnk_register;
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement lnk_login;
	
	//@FindBy(xpath="//div[normalize-space()='Your registration completed']")
	//WebElement txt_msg;
	
	public void  clickregister()
	{
		lnk_register.click();
	}
	
	public void clickloginlink()
	{
		lnk_login.click();
	}
	/*public String checktextmsg()
	{
		String txt =txt_msg.getText();
		return txt;
	}*/
	

}
