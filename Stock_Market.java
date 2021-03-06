package My_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class Stock_Market {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "E:\\Training\\Selenium\\Selenium\\drivers\\chromedriver_85.exe");
	WebDriver driver = new ChromeDriver();
	
	// PageLoad
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	//Open Page
	
	driver.get("https://www.google.com/");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	
	driver.findElement(By.name("q")).sendKeys("1 CAD to INR");
	driver.findElement(By.className("gNO89b")).click();
	String rupee1 = driver.findElement(By.xpath("//*[@id='knowledge-currency__updatable-data-column']/div[1]/div[2]/span[1]")).getText();
	//String rupee1= driver.findElement(By.cssSelector("span.DFlfde.SwHCTb")).getText(); //this also works
	System.out.println("1 CAD is " +rupee1+" rupees");
	Thread.sleep(3000);
	driver.get("https://money.tmx.com/en/quote/ABST");
	Thread.sleep(6000);
	String str1 = driver.findElement(By.xpath("//div[@class='sc-dHMjyi gzSWnW']")).getText();
	//String str1 = driver.findElement(By.cssSelector("div.sc-gmfbfk.efPjgm")).getText();//this also works
	System.out.println("The current value of ABST in TSX is " +str1 +" and yours avg is 14.34");
	
	// Implicitly wait
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Thread.sleep(3000);
	//driver.close();
	driver.get("https://money.tmx.com/en/quote/DOC");
	Thread.sleep(6000);
	String str2 = driver.findElement(By.cssSelector("div.sc-gmfbfk.efPjgm")).getText();
	//String str2 = driver.findElement(By.xpath("//div[@id=\'root\']/div[4]/div[2]/div/div/div/div[1]/div[2]/div")).getText();
	String bname = driver.findElement(By.cssSelector("div.sc-fYOzFx.ftvlBV")).getText();
	
	System.out.println("The current value of "+bname+" (DOC) in TSX is " +str2 +" and yours avg is 2.61");
	Thread.sleep(2000);
	
	driver.get("https://money.tmx.com/en/quote/FOOD");
	Thread.sleep(6000);
	String str3 = driver.findElement(By.cssSelector("div.sc-gmfbfk.efPjgm")).getText();
	
	System.out.println("The current value of FOOD is " +str3+" and your avg is 8.32");
	Thread.sleep(2000); 
	driver.close();
	}

}
