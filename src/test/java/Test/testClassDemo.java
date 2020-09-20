package Test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testClassDemo {

	 int invocationCount;

	 @Parameters({ "invocationCount" })
	 @BeforeClass
	 void BeginClass( @Optional("1") String invocationCount) {
	        this.invocationCount = Integer.parseInt(invocationCount);
	    }

	 @DataProvider(name="URLprovider")
	    private Object[][] getURLs() {
	        ArrayList<Object []> obj = new ArrayList<Object[]>(3 * this.invocationCount);

	        for(int iCount = 0; iCount < this.invocationCount; ++iCount) {
	            obj.add( new Object[] {"https://www.google.co.in/"} );
	            obj.add( new Object[] {"http://www.gmail.com/"} );
	            obj.add( new Object[] {"http://stackoverflow.com/"} );
	        }
	        Object[][] data = (Object[][]) obj.toArray();
	        return data;
	    }
	
	 @Test(dataProvider="URLprovider")
	    private void notePrice(String url) {
		 
		 String CurrentProjectPath = System.getProperty("user.dir");

			System.out.println("Path  " + CurrentProjectPath);

			System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");

			WebDriver driver = new ChromeDriver();
		 
	        driver.get(url);
	        System.out.println(driver.getTitle());  
	    }

}
