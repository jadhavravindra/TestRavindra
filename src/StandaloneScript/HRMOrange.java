package StandaloneScript;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.PredefinedActions;
import constant.FileConstant;

public class HRMOrange extends FileConstant {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(FileConstant.DriverKey, FileConstant.DriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(FileConstant.URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Verify - Login Scenario");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//div/input[@id='txtPassword']")).sendKeys("tB@B31HfVd");		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//div/input[@id='txtPassword']")).sendKeys("tB@B31HfVd");		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		
		System.out.println("Verify - Attendance Menu Expand ");
		driver.findElement(By.xpath("//a/span[@id='menu_attendance_Attendance']")).click();
		
		
		System.out.println("Verify - Punch in/out Page Scenario");
		driver.findElement(By.xpath("//a/span[@id='menu_attendance_punchIn']")).click();
		
		List <WebElement> list = driver.findElements(By.cssSelector("#menu_attendance_Attendance > div > ul li"));
		List <String> listOfAttendanceMenus = new ArrayList<String>();
		for (WebElement element : list) {
			listOfAttendanceMenus.add(element.getText());
			System.out.println(listOfAttendanceMenus);
			}
	}

}
