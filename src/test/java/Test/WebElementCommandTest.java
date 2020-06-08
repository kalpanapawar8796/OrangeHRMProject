package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommandTest {

	public static void main(String[] args) {

		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();

		// Launch Web site
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

		driver.manage().window().maximize();

		// clear command
		WebElement element = driver.findElement(By.xpath("//input[@id='fname']"));
		element.clear();

		// sendkey command
		element.sendKeys("My text");

		// isDisplayed
		boolean status = element.isDisplayed();
		System.out.println("Textfield status:" + status);

		// click command
		WebElement buttonele = driver.findElement(By.xpath("//button[@id='idOfButton']"));
		buttonele.click();

		/*// submit command
		buttonele.submit();*/
		// getcssValue
		System.out.println(driver.findElement(By.xpath("//button[@id='idOfButton']")).getCssValue("background"));

		// isEnabled
		boolean btnStatus = buttonele.isEnabled();
		System.out.println("Button Status : " + btnStatus);

		// getAttribute
		System.out.println(buttonele.getAttribute("id"));

		//getsize
		Dimension dimensions = buttonele.getSize();  
		System.out.println("Height :" + dimensions.height + "Width : "+ dimensions.width);  
		
		//getLocation
		Point point = buttonele.getLocation();  
		System.out.println("X cordinate : " + point.x + "Y cordinate: " + point.y);  
		
		// isSelected
		WebElement Radiobtn = driver.findElement(By.xpath("//input[@id='female']"));
		Radiobtn.click();
		System.out.println("Radion button Status: " + Radiobtn.isSelected());

		// gettext
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'This is a link')]"));
		System.out.println(link.getText());

		// getTagname
		System.out.println(link.getTagName());

	}
}
