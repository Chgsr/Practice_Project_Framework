package com.automation.Guru99.Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{

	@Test
	public void GURULoginTest() throws FrameworkExceptions, IOException {

		getExtenttest().log(LogStatus.PASS, "Browser Opened Successfully");
		
		String URL= POJO_Utility.GetConf().GetPropertyValue("GURU99_URL");
		
		getDriver().get(URL);
		
		getExtenttest().log(LogStatus.PASS, "Browser Navigated to: "+URL);
		
		WebElement Username= getDriver().findElement(By.xpath(POJO_Utility.GetOr().GetPropertyValue("GURU_UserID_Xpath")));
		
		Username.clear();
		String username = POJO_Utility.GetConf().GetPropertyValue("GURU99_Username");
		Username.sendKeys(username);
		getExtenttest().log(LogStatus.PASS, "Username Entered As: "+username);
		
		WebElement Password= getDriver().findElement(By.xpath(POJO_Utility.GetOr().GetPropertyValue("GURU_Password_Xpath")));
		Password.clear();
		String password= POJO_Utility.GetConf().GetPropertyValue("GURU99_Password");
		Password.sendKeys(password);
		getExtenttest().log(LogStatus.PASS, "Password Entered As: "+password);
		
		getDriver().findElement(By.xpath(POJO_Utility.GetOr().GetPropertyValue("GURU_Login_Xpath"))).click();
		
		getExtenttest().log(LogStatus.PASS, " Clicked On Login ");
		
		WebElement Loginconfirmation= getDriver().findElement(By.xpath(POJO_Utility.GetOr().GetPropertyValue("GURU_LOGIN_Confir_Xpath")));
		
		if(Loginconfirmation.isEnabled()&&Loginconfirmation.isDisplayed())
		{
			String TXT=Loginconfirmation.getText();
			if(TXT.equalsIgnoreCase("Welcome To Manager's Page of Guru99 Bank"))
			{
				getExtenttest().log(LogStatus.PASS, "Logged in Successfully to the Guru99");
			}
		}
		
		
		
		
		
		
		
		
		
	}

}
