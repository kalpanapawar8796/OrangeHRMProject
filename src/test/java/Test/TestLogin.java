package Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.DashboardPage;
import Pages.LoginPage;
import Utility.DataLayer;

public class TestLogin {

	public static WebDriver driver;
	String log4jConfPath;
	private static Logger log = LogManager.getLogger("devpinoyLogger");

	@DataProvider(name = "readData")
	public Object[][] testData() throws IOException {
		String projectPath = System.getProperty("user.dir");
		DataLayer dl = new DataLayer();
		Object[][] data = dl.realExcel(projectPath + "/Excel/data.xlsx", "Sheet1");
		return data;

	}

	@BeforeClass
	public void setUpBrowser() {

		log4jConfPath = "C:\\Users\\Win\\Desktop\\Seleniummaterial27thNov\\OrangeHRMProjectDemo\\src\\main\\java\\log4j2.properties";

		PropertyConfigurator.configure(log4jConfPath);

		String CurrentProjectPath = System.getProperty("user.dir");

		System.out.println("Path  " + CurrentProjectPath);

	
		System.setProperty("webdriver.chrome.driver", CurrentProjectPath + "/Drivers/ChromeDriver/chromedriver_5.exe");
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		/*
		 * // Page load : default time out is 1min
		 * driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES); //
		 * findElement : default zero second(while targetting ,or seraching
		 * element) driver.manage().timeouts().implicitlyWait(3,
		 * TimeUnit.SECONDS); // js Timeout : depend on browser or server
		 * driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		 * 
		 */

		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.debug("Opened Website");
	}

	@Test(priority = 1, dataProvider = "readData")
	public void loginToOrangeHRM(String username, String password) {

		LoginPage login = new LoginPage(driver);

		login.EnterUsername(username);
		log.debug("Entered Username");

		login.EnterPassword(password);
		log.debug("Entered Password");

		login.ClickOnLoginButton();
		log.debug("Clicked on login button");

		DashboardPage dashboard = new DashboardPage(driver);
		System.out.println("Logged in user name : " + dashboard.getLoggedInUsername());
		Assert.assertEquals(dashboard.getLoggedInUsername(), "Welcome Admin");
		log.info("Logged in successfully");
	}
	@Test
	public void demo(){
		System.out.println("dsffffffffsdfsdfsdfdsfs");
	}

	public void takeScreenshot() throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshotFolder/failed-test.png"));
	}

	// It will execute after every test execution
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println(result.getName() + "  : Failure");
			try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		} else {

			System.out.println(result.getName() + " : Success");
		}

	}

	@AfterClass
	public void closeBrowser() {

		driver.close();
		driver.quit();

	}

}
