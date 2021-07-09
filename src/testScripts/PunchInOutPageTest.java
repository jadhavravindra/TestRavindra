package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.PredefinedActions;
import pages.AttendanceMenu;

public class PunchInOutPageTest extends PredefinedActions {
	//getTitle for verification of page
	
	
	@Test
	public void verifyPunchInOutPage() {
			
		
		AttendanceMenu attendanceMenu = new AttendanceMenu();
	
		String PuchInOutURL = attendanceMenu.goToPunchInOutPage(); 
		
		System.out.println("Verify - Punch In out Page");
		Assert.assertTrue(PuchInOutURL.contains("/attendance/my_punch_in_out"), "Punch In/Out Page URL is not Correct");
		
		//PredefinedActions.tearDown();
	}
}
