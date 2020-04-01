package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	By UsernameTxt = By.name("txtUsername");
	By PasswordTxt = By.name("txtPassword");
	By LoginBtn = By.name("Submit");

	public void EnterUsername(String username){
		driver.findElement(UsernameTxt).clear();
		driver.findElement(UsernameTxt).sendKeys(username);
	}
	
	public void EnterPassword(String password){
		driver.findElement(PasswordTxt).clear();
		driver.findElement(PasswordTxt).sendKeys(password);
	}
	
	public void ClickOnLoginButton(){
		driver.findElement(LoginBtn).click();
	}

}
