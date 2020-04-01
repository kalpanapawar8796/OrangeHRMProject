package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;
	public DashboardPage(WebDriver driver){
		this.driver = driver;
	}
	
	By LoggedInUsername = By.partialLinkText("Welcome");
	
	public String getLoggedInUsername(){
		return driver.findElement(LoggedInUsername).getText();
	}
	
}
