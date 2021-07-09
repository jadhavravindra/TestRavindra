package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.PredefinedActions;
import utility.ExcelFileReader;

public class LoginPage extends PredefinedActions{
		
	WebElement logoElement,
			   loginPanelElement,
			   loginBtnElement;
	public boolean isLogoDisplayed() {
		
		logoElement = PredefinedActions.getElement("xpath", "//div[@id='divLogo']", false);
		return PredefinedActions.isElementDisplayed(logoElement);
	}
	
	public boolean isLoginPanelDisplayed() {
		
		loginPanelElement = PredefinedActions.getElement("xpath", "//div[text()='LOGIN Panel']", true);
		return PredefinedActions.isElementDisplayed(loginPanelElement);
	}
	
	public void enteredUsername(String username) {
		WebElement usernameElement = PredefinedActions.getElement("xpath", "//input[@name='txtUsername']", false);
		PredefinedActions.sendkeys(usernameElement, username);
	}
	
	public void enteredPassword(String passwd) {
		WebElement passwordElement = PredefinedActions.getElement("xpath", "//input[@name='txtPassword']", false);
		PredefinedActions.sendkeys(passwordElement, passwd);
	}
	
	public DashBoardPage clickToLoginBtn() {
		
		loginBtnElement = PredefinedActions.getElement("xpath", "//input[@id='btnLogin']", true);
		if(PredefinedActions.isButtonEnabled(loginBtnElement)) {
			loginBtnElement.click();
		}
		
		return new DashBoardPage();
	}
	
	public void doLogin() throws IOException {
		ExcelFileReader excelreader = new ExcelFileReader();
		LoginPage loginpage = new LoginPage();
		loginpage.enteredUsername(excelreader.username);//Admin
		loginpage.enteredPassword(excelreader.password);//"tB@B31HfVd"
		loginpage.clickToLoginBtn();
		
	}
	
}
