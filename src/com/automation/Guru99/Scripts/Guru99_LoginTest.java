package com.automation.Guru99.Scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Pageobjects.Guru99_Login;
import com.automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Guru99_LoginTest extends BaseTest {
	
	@Test
	public void Guru99LoginTest() throws EncryptedDocumentException, FrameworkExceptions, IOException {
		
		getExtenttest().log(LogStatus.PASS, "Browser Opened Successfully");
		
		String URL = POJO_Utility.GetConf().GetPropertyValue("GURU99_URL");
		getDriver().get(URL);
		getExtenttest().log(LogStatus.PASS, "Entered URL as: "+URL);
		
		Guru99_Login.Enter_Username(POJO_Utility.GetexcelReader().GetCellValue("index", "0", 4, 0));
		getExtenttest().log(LogStatus.PASS, "Username Taken From ExcelSheet");
		Guru99_Login.Enter_Password(POJO_Utility.GetConf().GetPropertyValue("GURU99_Password"));
		Guru99_Login.Click_Login();
		Guru99_Login.Validate_Login();

	}

}
