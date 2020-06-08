package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {

	public static void main(String[] args) {

		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();
	     driver.navigate().to("https://www.spicejet.com/");  
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());  
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();  
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); 
        
        driver.close();

	}

}
