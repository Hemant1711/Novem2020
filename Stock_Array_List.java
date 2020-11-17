package My_Project;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stock_Array_List {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException   
	{
      
	System.setProperty("webdriver.chrome.driver", "E:\\Training\\Selenium\\Selenium\\drivers\\chromedriver_85.exe");
	WebDriver driver = new ChromeDriver();
	List<String> sList = new ArrayList<String>();
    sList.add("DOC");
    sList.add("FOOD");
    sList.add("ABST");
    sList.add("BLU");
    sList.add("SU");
  
    int oStock = sList.size();
    
    for(int i=0; i<oStock;i++) {
    	String sName = sList.get(i);
    	
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	// IMPORTANT: Save the old System.out!
    	PrintStream old = System.out;
    	// Tell Java to use your special stream
    	System.setOut(ps);
    	// Print some output: goes to your special stream
    	System.out.println("https://money.tmx.com/en/quote/"+sName);
    	// Put things back
    	System.out.flush();
    	System.setOut(old);
    	// Show what happened
    	//System.out.println(baos.toString());
    	driver.get(baos.toString());
    	Thread.sleep(4000);
    	String stockvalue = driver.findElement(By.cssSelector("div.sc-gmfbfk.efPjgm")).getText();
    	String bname = driver.findElement(By.cssSelector("div.sc-fYOzFx.ftvlBV")).getText();
    	System.out.println("The current value of "+bname+" in TSX is " +stockvalue);
    	
	}
	driver.close();
    
	}
}