package mod5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BrowserTest 
{
	WebDriver driver;
	String URL = "https://www.google.com/";
	@Parameters("B")
	
	/*@Test(priority=1)
	  public void openURL()
		{
		driver.get("https://www.google.com/");
		//driver.navigate().to(URL);
		}*/
  @Test(priority=0)
  public void beforeTest(String browser) 
	{
	  try {
		  if(browser.equalsIgnoreCase("Chrome"))  
		  	{
			  System.setProperty("webdriver.chrome.driver","E:\\Training\\Selenium\\Selenium\\drivers\\chromedriver_85.exe");
			  driver = new ChromeDriver();
			}
		  else if(browser.equalsIgnoreCase("Firefox"))
		  	{
			  System.setProperty("webdriver.gecko.driver","E:\\Training\\Selenium\\Selenium\\drivers\\geckodriver_0.24.exe");
			  driver = new FirefoxDriver();
		  	}
		  else if(browser.equalsIgnoreCase("IE"))
		  	{
			  System.setProperty("webdriver.ie.driver","E:\\Training\\Selenium\\Selenium\\drivers\\IEDriverServer_3.4.exe");
			  driver = new InternetExplorerDriver();
		  	}
	  	}
	  catch(WebDriverException ex)
	  	{
		  System.out.println(ex.getMessage());
	  	}
	  }
 
@Test(priority=1)
  public void openURL() {
	  driver.navigate().to(URL);
  }

  

}
