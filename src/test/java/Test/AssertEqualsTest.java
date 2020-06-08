package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertEqualsTest {

	public static void main(String[] args) {
		
		/*AssertEquals() is a method used to compare the actual and expected results.
		If both the actual and expected results are same, then the assertion pass with no exception and 
		the test case is marked as "passed". If both the actual and expected results are not the same,
		then the assertion fails with an exception and the test case is marked as "failed".*/
		
		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.spicejet.com/");

		 Assert.assertEquals("Adult1",driver.findElement(By.id("divpaxinfo")).getText()); 
		 
		 System.out.println(" PASS : "+ driver.findElement(By.id("divpaxinfo")).getText());  
		 
		 driver.close();
		
	}

}
