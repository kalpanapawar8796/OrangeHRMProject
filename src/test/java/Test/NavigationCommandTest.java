package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommandTest {

	public static void main(String[] args) {
	
		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();

		// Launch Web site
		driver.get("https://www.testandquiz.com/selenium/testing.html");

		driver.manage().window().maximize();
		//a[contains(text(),'This is a link')]
		 //Click on the Link Text using click() command    
        driver.findElement(By.linkText("This is a link")).click();  

        //Go back to Home Page  
        driver.navigate().back();   
        System.out.println(driver.getCurrentUrl());

        //Go forward to Registration page  
        driver.navigate().forward();  
        System.out.println(driver.getCurrentUrl());

        // Go back to Home page  
        driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");  
        System.out.println(driver.getCurrentUrl());
        
        //Refresh browser  
        driver.navigate().refresh();  
        System.out.println(driver.getCurrentUrl());
        //Closing browser  
        driver.close();   
	}

}
