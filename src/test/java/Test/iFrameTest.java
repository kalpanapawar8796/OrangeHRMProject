package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class iFrameTest {
	/*
	 * iFrame is a HTML document embedded inside an HTML document. iFrame is
	 * defined by an <iframe></iframe> tag in HTML. Switch between iFrames we
	 * have to use the driver’s switchTo().frame command
	 * 
	 * switchTo.frame(int frameNumber): Pass the frame index and driver will switch to that frame. 
	 * switchTo.frame(string frameNameOrId): Pass the frame element Name or ID and driver will switch to that frame.
	 * switchTo.frame(WebElement frameElement): Pass the frame web element and driver will switch to that frame.
	 * 
	 */
	
	public static WebDriver driver;
	
	@BeforeTest
	public void findNumberOfiframe(){
	String CurrentProjectPath = System.getProperty("user.dir");

	System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

	driver = new ChromeDriver();
	

    driver.get("file:///C:/Users/Win/Desktop/Seleniummaterial27thNov/OrangeHRMProjectDemo/iframe.html");

	
	// by two ways we get total number of iframes
	
	//By executing a java script
	 JavascriptExecutor exe = (JavascriptExecutor) driver;
	 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
	 System.out.println("Number of iframes on the page are " + numberOfFrames);
	 
	//By finding all the web elements using iframe tag
	 List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
	 System.out.println("The total number of iframes are " + iframeElements.size());
	 	 
	}
	//Switch to Frames by Index
	@Test(priority=1)
	public void frameByIndex(){
	
		 //Switch by Index
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//input[@value='Pista']")).click();
		 int a = driver.findElements(By.xpath("//input [@name='group1']")).size();  
	        System.out.println(a);  
	        for(int i=1;i<=a;i++)  
	        {  
	            driver.findElements(By.xpath("//input[@name='group1']")).get(2).click();  
	        }  
	        System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(2).getAttribute("value"));
		 driver.switchTo().defaultContent();
		
	}
	//Switch by frame name
	@Test(priority=2)
	public void frameByName(){
	
		 
		 driver.switchTo().frame("iframe1");
		 driver.findElement(By.xpath("//input[@value='Cashew']")).click();
		 System.out.println(driver.findElement(By.xpath("//input[@value='Cashew']")).getAttribute("value"));
		 driver.switchTo().defaultContent();
		
	}
	//Switch by frame ID
	@Test(priority=3)
	public void frameByID(){
	
		 
		 driver.switchTo().frame("IF2");
		 driver.findElement(By.xpath("//input[@value='Potato']")).click();
		 System.out.println(driver.findElement(By.xpath("//input[@value='Potato']")).getAttribute("value"));
		 driver.switchTo().defaultContent();
		 driver.close();
	}


}
