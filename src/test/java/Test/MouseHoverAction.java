package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseHoverAction {
	public static WebDriver driver;

	@Test
	public void rightClickNDoubleClick() throws InterruptedException {
		String CurrentProjectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		driver = new ChromeDriver();
		// Launch the URL
		driver.get("http://demoqa.com/menu/");
		System.out.println("demoqa webpage Displayed");

		// Maximise browser window
		driver.manage().window().maximize();

		// Adding wait
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		// Instantiate Action Class
		Actions actions = new Actions(driver);
		// Retrieve WebElement 'Main Item 2' to perform mouse hover
		WebElement menuOption = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
		// Mouse hover menuOption 'Main Item 2'
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'Main Item 2' from Menu");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Now Select 'Rock' from sub menu which has got displayed on mouse
		// hover of 'Music'
		Thread.sleep(5000);
		//WebElement subMenuOption = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"))));
		WebElement subMenuOption = driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));
		// Mouse hover menuOption 'Rock'
		actions.moveToElement(subMenuOption).perform();
		System.out.println("Done Mouse hover on 'Rock' from Menu");

		// Now , finally, it displays the desired menu list from which required
		// option needs to be selected
		// Now Select 'Alternative' from sub menu which has got displayed on
		// mouse hover of 'Rock'
		WebElement selectMenuOption = driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"));
		//WebElement selectMenuOption = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"))));

		selectMenuOption.click();
		System.out.println("Selected 'Alternative' from Menu");

		// Close the main window
		driver.close();

	}
}
