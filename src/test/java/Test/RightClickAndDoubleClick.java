package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClickAndDoubleClick {

	public static WebDriver driver;

	@Test
	public void rightClickNDoubleClick() {
		String CurrentProjectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		driver = new ChromeDriver();

		driver.get("http://demoqa.com/buttons");
		
		 //Maximise browser window
		   driver.manage().window().maximize();
			 
		   //Instantiate Action Class
		   Actions actions = new Actions(driver);
			 
		   //Retrieve WebElement to perform right click
		   WebElement btnElement = driver.findElement(By.id("rightClickBtn"));
			 
		   //Right Click the button to display Context Menu&nbsp;
		   actions.contextClick(btnElement).perform();
		   System.out.println("Right click Context Menu displayed");
			 
		System.out.println(driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText());
		
		
		//Double Click
		
		 //Retrieve WebElement to perform double click WebElement
		 btnElement = driver.findElement(By.id("doubleClickBtn")); 
		 
		 //Double Click the button 
		 actions.doubleClick(btnElement).perform(); 
		 
		 System.out.println("Button is double clicked"); 
		
		 System.out.println(driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText());
		   // Close the main window 
		   driver.close();
		   

	}

}
