package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class DragNDropTest1 {
 
	public static WebDriver driver;
	
	@Test
	public void DragNDrop(){	
	
		 //Note: Following statement is required since Selenium 3.0, 
    		//optional till Selenium 2.0
    		//Set system properties for geckodriver 
		String CurrentProjectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		driver = new ChromeDriver();
		 
		String URL = "file:///C:/Users/Win/Desktop/Seleniummaterial27thNov/OrangeHRMProjectDemo/dragandrop.html";
		 
		driver.get(URL);
		 
		// It is always advisable to Maximize the window before performing DragNDrop action		 
		driver.manage().window().maximize();
		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		//Actions class method to drag and drop		
		Actions builder = new Actions(driver);
		 
		WebElement from = driver.findElement(By.id("drag1"));
		 
		WebElement to = driver.findElement(By.id("div1"));	 
		//Perform drag and drop
		builder.dragAndDrop(from, to).perform();
		
		/*//verify text changed in to 'Drop here' box 
		String textTo = to.getText();

		if(textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		}else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}*/
	
		driver.close();

	}	
 
}