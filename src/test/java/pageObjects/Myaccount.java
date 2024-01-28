package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount extends BasePage {

	public Myaccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement lnk_myaccount;

	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement lnk_logout;
	
	public boolean checklogo()
	{
		boolean status=lnk_myaccount.isDisplayed();
		return status;
	}
	
	public void clicklogout()
	{
		lnk_logout.click();
	}

}
