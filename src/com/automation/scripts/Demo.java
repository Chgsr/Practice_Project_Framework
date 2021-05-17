package com.automation.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Demo extends BaseTest {

	@Test
	public void Gmail() throws IOException, FrameworkExceptions {


		getExtenttest().log(LogStatus.PASS, "Browser Launched Successfully");
		
		getDriver().get("https://www.gmail.com");
		
		getExtenttest().log(LogStatus.PASS, "Navigated to: "+"https://www.gmail.com");
		
		getDriver().findElement(By.id(POJO_Utility.GetOr().GetPropertyValue("Gmail_Email_ID"))).sendKeys("gunashekarchalla@gmail.com");
		getExtenttest().log(LogStatus.PASS, "Data Typing Action is done on USer name");
		
		WebElement NXT= getDriver().findElement(By.xpath(POJO_Utility.GetOr().GetPropertyValue("Gmail_Next_Xpath")));
		NXT.click();
		getExtenttest().log(LogStatus.PASS, "Clicked On Next Button");
		
		
	}
}
