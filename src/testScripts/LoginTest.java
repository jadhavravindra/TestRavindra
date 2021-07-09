package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.PredefinedActions;
import pages.LoginPage;
import utility.ExcelFileReader;
//Assignment test cases : https://docs.google.com/spreadsheets/d/1fXspjL_tJyOJLp29CGtYmd3yby1DlNd9TNp0yTiNqxY/edit?pli=1#gid=671249761
public class LoginTest {

	@Test
  
	public void verifyLoginTest() throws IOException {
		PredefinedActions.tearUp();
		LoginPage loginpage = new LoginPage();
		System.out.println("Verify - Logo is Diplayed");
		Assert.assertTrue(loginpage.isLogoDisplayed(), "Logo is not displayed");
		
		System.out.println("Verify - Login Panel");
		Assert.assertTrue(loginpage.isLoginPanelDisplayed(), "Login Panel is not displayed");
		
		ExcelFileReader excelreader = new ExcelFileReader();
		//loginpage.enteredUsername(excelreader.username);
		//loginpage.enteredPassword(excelreader.password);
		loginpage.enteredUsername("admin");
		loginpage.enteredPassword("tB@B31HfVd");
		loginpage.enteredUsername("admin");
		loginpage.enteredPassword("tB@B31HfVd");
		PredefinedActions.tearDown();
	}

	}
	