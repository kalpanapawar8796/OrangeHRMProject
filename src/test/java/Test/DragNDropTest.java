package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
/**
 * clickAndHold(WebElement element) - Clicks a web element at the middle(without releasing).
moveToElement(WebElement element) - Moves the mouse pointer to the middle of the web element without clicking.
release(WebElement element) - Releases the left click (which is in pressed state).
build() - Generates a composite actio
 * 
 * 
 * **/
public class DragNDropTest {

	
	@Test
	public void dragAndDropDemo() throws InterruptedException{
		String CurrentProjectPath = System.getProperty("user.dir");

	System.out.println("Path  " + CurrentProjectPath);

	System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

	WebDriver driver = new ChromeDriver();
	
	
		driver.get("https://www.testandquiz.com/selenium/testing.html");  
	
	Thread.sleep(5000);
	
	//WebElement on which drag and drop operation needs to be performed  
    WebElement source = driver.findElement(By.id("sourceImage"));  

//WebElement to which the above object is dropped  
    WebElement target = driver.findElement(By.id("targetDiv"));  
       
//Creating object of Actions class to build composite actions  
    Actions act = new Actions(driver);  
       
//Performing the drag and drop action  
 
	act.dragAndDrop(source, target).build().perform();
	
	
	//act.clickAndHold(from).moveToElement(to).release(to).build().perform();
	System.out.println("Done....!!");
	//*[@id="sourceImage"]
	
	if(driver.findElement(By.xpath("//div/img[id='sourceImage']")).isDisplayed())					
 	{		
     	System.out.println("Perfect Displayed !!!");					
 	}
	else
 	{
    	System.out.println("Perfect not Displayed !!!");					
 	}	
	driver.close();
}
	
}
	

