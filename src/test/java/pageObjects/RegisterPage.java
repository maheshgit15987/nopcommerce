package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage  extends BasePage{
	
    public WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txt_firstname;
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txt_lastname;
	@FindBy(xpath="//input[@id='Email']")
	WebElement txt_email;
	@FindBy(xpath="//input[@id='Password']")
	WebElement txt_password;
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement txt_confirmpassword;
	@FindBy(xpath="//button[@id='register-button']")
	WebElement btn_register;
	
	
	
	
	public void setusername(String firstname)
	{
		txt_firstname.sendKeys(firstname);
		
	}
	public void setlastname(String lastname)
	{
		txt_lastname.sendKeys(lastname);
		
	}
	public void setemail(String email)
	{
		txt_email.sendKeys(email);
		
	}
	
	
	public void setpassword(String password)
	{
		txt_password.sendKeys(password);
	}
	public void setconfirmpassword(String confirmpassword)
	{
		txt_confirmpassword.sendKeys(confirmpassword);
	}
	
	public void clickregister()
	{
		btn_register.click();
	}
	

}
