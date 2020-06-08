package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertFalseTest {

	public static void main(String[] args) {

		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.spicejet.com/");
		
/*		Assertfalse : Assertion verifies the boolean value returned by a condition.
 *  If the boolean value is false, then assertion passes the test case, and 
 *  if the boolean value is true, then assertion aborts the test case by an exception.*/
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		Assert.assertFalse(true); // condition must be false
		System.out.println("This line will not execute");
		
		
		driver.close();

	}

}
