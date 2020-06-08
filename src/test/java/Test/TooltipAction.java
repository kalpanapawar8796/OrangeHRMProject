package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TooltipAction {
	public static WebDriver driver;

	@Test
	public void rightClickNDoubleClick() throws InterruptedException {
		String CurrentProjectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		driver = new ChromeDriver();
		// Launch the URL
		driver.get("http://demoqa.com/tool-tips");

		System.out.println("demoqa webpage Displayed");

		// Maximise browser window
		driver.manage().window().maximize();

		// Instantiate Action Class
		Actions actions = new Actions(driver);

		// Retrieve WebElement
		WebElement element = driver.findElement(By.id("toolTipButton"));

		// Use action class to mouse hover
		actions.moveToElement(element).perform();
		Thread.sleep(3000);

		//WebElement toolTip = driver.findElement(By.cssSelector(".tooltiptext"));
		WebElement toolTip = driver.findElement(By.cssSelector("div[id=buttonToolTip]"));
		// To get the tool tip text and assert
		String toolTipText = toolTip.getText();
		System.out.println("toolTipText-->" + toolTipText);

		// Verification if tooltip text is matching expected value
		if (toolTipText.equalsIgnoreCase("You hovered over the Button")) {
			System.out.println("Pass* : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}
		
		 Assert.assertEquals("You hovered over the Button",toolTipText); 
System.out.println("Matched");
		// Close the main window
		driver.close();

	}
}
