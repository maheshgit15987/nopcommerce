package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@Parameters({"browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(this.getClass());
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","regression","master"})
  public void teardown()
   {
	   driver.quit();
   }
  
  public String randomstring()
  {
	 String alpha= RandomStringUtils.randomAlphabetic(5);
	 return alpha;
  }
  public String randomnumeric()
  {
	 String numeric= RandomStringUtils.randomNumeric(5);
	 return numeric;
  }
  public String alphanumeric()
  {
	 String alphanumeric= RandomStringUtils.randomAlphanumeric(8);
	 return alphanumeric;
  }
  public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
