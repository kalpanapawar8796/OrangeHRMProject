package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;

public class AlertTest {

	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {
		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();

		// Alert Message handling

		driver.get("http://demo.guru99.com/test/delete_customer.php");
//https://www.testandquiz.com/selenium/testing.html
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = alert.getText();

		// Displaying alert message
		System.out.println(alertMessage);
		
		//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		WebDriverWait wait = new WebDriverWait (driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		// Accepting alert
		alert.accept();
	
		System.out.println("alert");
	}

}
