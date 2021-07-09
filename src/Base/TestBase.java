package Base;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import pages.AttendanceMenu;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class TestBase {

	public void setUp() throws IOException {
		System.out.println("Start Test with Chrome Browser.....");
		PredefinedActions.tearUp();

		System.out.println("Verifying Login......");
		LoginPage loginpage = new LoginPage();
		loginpage.doLogin();
		System.out.println("Verifying DashBoardPage......");
		DashBoardPage dashboardPage = new DashBoardPage();
		// System.out.println("VERIFY - Dashboard heading is displayed");
		// Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed(), "Dashboard title
		// not displayed!");
	}

	AttendanceMenu goto_Attendance() {
		AttendanceMenu attendanceMenu = new AttendanceMenu();
		return attendanceMenu;
	}

	public String goToPunchInOutPage() {
		WebElement punchInOutMenu = PredefinedActions.getElement("xpath", "//a/span[text()='Punch In/Out']", true);
		PredefinedActions.clickOnElement(punchInOutMenu, true);
		return PredefinedActions.getCurrentPageURL();

	}
	/*
	 * MyInfoPage goto_MyInfoPage() { MyInfoPage myInfoPage = new MyInfoPage();
	 * return myInfoPage; }
	 * 
	 * PIMPage goto_PIMPage() { PIMPage pimPage = new PIMPage(); return pimPage; }
	 * 
	 * AdminPage goto_Admin() { AdminPage adminPage = new AdminPage(); return
	 * adminPage; }
	 */

}
