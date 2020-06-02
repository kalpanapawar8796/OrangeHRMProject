package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

		driver.manage().window().maximize();
		// Double click the button to launch an alertbox
		Actions action = new Actions(driver);
		WebElement link = driver.findElement(By.xpath("//button[text()='Double-click to generate alert box']"));
		action.doubleClick(link).perform();
		// Switch to the alert box and click on OK button
		Alert doubleclickalert = driver.switchTo().alert();
		System.out.println("Alert Text : " + doubleclickalert.getText());
		doubleclickalert.accept();

		// Handling alert boxes
		// Click on generate alert button

		driver.findElement(By.xpath("//button[text()='Generate Alert Box']")).click();

		// Using Alert class to first switch to or focus to the alert box
		Alert alert = (Alert) driver.switchTo().alert();

		// Using accept() method to accept the alert box
		alert.accept();

		// Handling confirm box
		// Click on Generate Confirm Box
		driver.findElement(By.xpath("//button[text()='Generate Confirm Box']")).click();

		Alert confirmBox = (Alert) driver.switchTo().alert();

		// Using dismiss() command to dismiss the confirm box
		// Similarly accept can be used to accept the confirm box
		((Alert) confirmBox).dismiss();
		
		driver.close();

	}

}
