package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {

	public static void main(String[] args) {


		   
		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

		WebDriver driver = new ChromeDriver();
	   driver.get("file:///C:/Users/Win/Desktop/Seleniummaterial27thNov/OrangeHRMProjectDemo/Radio.html");
	   
	
        int a = driver.findElements(By.xpath("//input [@name='group1']")).size();  
        System.out.println(a);  
        for(int i=1;i<=a;i++)  
        {  
            driver.findElements(By.xpath("//input[@name='group1']")).get(2).click();  
        }  

        
        driver.findElement(By.xpath("//input[@value='Potato']")).click();
        
        driver.close();
        
	}

}
