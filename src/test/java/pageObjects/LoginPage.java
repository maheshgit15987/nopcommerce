package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txt_pwd;

	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement btn_submit;
	
	public void setusername(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btn_submit.click();
	}
	


}
