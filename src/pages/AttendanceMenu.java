package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import Base.PredefinedActions;

public class AttendanceMenu extends PredefinedActions {
	WebElement attendanceMenuBtn;
	LoginPage loginPage ;
	
	
	
	public void ClickOnAttandanceMenu() {
		
		WebElement attendanceMenuBtn = LoginPage.getElement("xpath", "//a/span[text()='Attendance']", true);
		if(LoginPage.isButtonEnabled(attendanceMenuBtn)) {
			attendanceMenuBtn.click();
		}
	}

	public List<String> verifyAttendanceMenuList() {
		List<String> list = PredefinedActions.getElementMenuList("css", "#menu_attendance_Attendance > div > ul li", false);
		return list;
	}
	
	public String goToPunchInOutPage() {

		WebElement punchInOutMenu = PredefinedActions.getElement("xpath", "//a/span[text()='Punch In/Out']", true);
		PredefinedActions.clickOnElement(punchInOutMenu, true);

		return PredefinedActions.getCurrentPageURL();

	}
}
