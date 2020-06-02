package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/** Drop Down
 * Select selobj = new Select(select locator);
 * 
 * 1. Select by id
 * selobj.selectByIndex(5) // accept integer value
 * 
 * 2. Select by selectByVisibleText
 * selobj.selectByVisibleText("Database Testing");  
 * 
 * 3. Select by value
 * selobj.selectByValue("Database") 
 * */
public class DropDownTest {
		
	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {
		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();
 
		driver.get("https://www.testandquiz.com/selenium/testing.html");   
		
		Select selobj = new Select(driver.findElement(By.id("testingDropdown")));
		
		//selobj.selectByIndex(5);
	
		selobj.selectByValue("Performance");
		
		Thread.sleep(5000);
		
		selobj.selectByVisibleText("Database Testing");
		
	
	}
}
