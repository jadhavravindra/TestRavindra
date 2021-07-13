package Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import utility.ExcelFileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.FileConstant;
import pages.LoginPage;

public class PredefinedActions {
	private static WebDriver driver;
	
	@BeforeMethod
	public static void tearUp() throws IOException {
		System.setProperty(FileConstant.DriverKey, FileConstant.DriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(FileConstant.URL);//https://ravindrajadhav-trials71.orangehrmlive.com/client/#/dashboard
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public static void tearDown() {
		driver.close();	
	}
		
	public static WebElement getElement(String locatorType , String locator , boolean isWaitRequired) {
		WebElement element ;
		
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		switch (locatorType.toLowerCase()) {
			
		case "xpath":
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			}
			else {
				element = driver.findElement(By.xpath(locator));
			}
			
			break;
		case "id":
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			}
			else {
				element = driver.findElement(By.id(locator));
			}
			
			break;
		case "css":
			if(isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			}
			else {
				element = driver.findElement(By.cssSelector(locator));
			}
			
			break;
		default:
			element = null;
			System.out.println("Invalid LocatorType");
			
		}
		return element;
	}
	
	public static List getElementMenuList(String locatorType,String locator,boolean isWaitRequired) {
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		List <WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locatorType, locator, isWaitRequired)));
		List <String> listOfAttendanceMenus = new ArrayList<String>();
		for (WebElement element : list) {
			listOfAttendanceMenus.add(element.getText());
			}
		
		return listOfAttendanceMenus;
	}
	
	public static void scrollToElement(WebElement element) {
		if(!isElementDisplayed(element)) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true)", element);
		}
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		else {
			scrollToElement(element);
		return element.isDisplayed(); 
		}
	}

	public static boolean isButtonEnabled(WebElement element) {
		if(element.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static WebElement clickOnElement(WebElement element, boolean isWaitRequired){
		
			if(isWaitRequired) {
				WebDriverWait wait = new WebDriverWait(driver, 5L);
				wait.until(ExpectedConditions.visibilityOf(element)).click();
			}
			else {
				element.click();
			}	
			return element;
	}
	public static void sendkeys(WebElement element,String text) {
		
		try{
			if(element.isEnabled())
				element.sendKeys(text);
		}
		catch(Exception e){
			throw new ElementNotInteractableException("Element that yoou are trying to input is not clickable");
			
		}
	}
	

	public static String getCurrentPageURL() {
			return driver.getCurrentUrl();
			 
		}
	
	
	public static void staticWait(int waitingTime) {
		try {
			Thread.sleep(waitingTime);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void m1() {
		System.out.println("test");
	}
	
	
}
