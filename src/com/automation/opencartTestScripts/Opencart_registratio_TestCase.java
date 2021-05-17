package com.automation.opencartTestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Pageobjects.Opencart_registration;
import com.automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Opencart_registratio_TestCase extends BaseTest {
	
	private String URL;

	
	@Test
	public void OPencartRegistration() throws IOException, FrameworkExceptions {
		
		getExtenttest().log(LogStatus.PASS, " Browser Opened Successfully ");
		
		getDriver().get(POJO_Utility.GetConf().GetPropertyValue("Opencart_URL"));
		
		URL=getDriver().getCurrentUrl();
		
		getExtenttest().log(LogStatus.PASS, " Entered URL is: "+URL);

		Opencart_registration.Click_My_Account();
		Opencart_registration.Click_Register();
		Opencart_registration.EnterFirstname("Gunashekar11");
		Opencart_registration.EnterLastname("Reddy11");
		Opencart_registration.Email("gunashekarreddychalla1@gmail.com");
		Opencart_registration.PhoneNumber("8463904594");
		Opencart_registration.Password("Aqwsed@0129");
		Opencart_registration.ConfirmPassword("Aqwsed@0129");
		Opencart_registration.AgreePolicies();
		Opencart_registration.ClickonContinue();
		Opencart_registration.Validate_Accnt_Created_Or_Not();
	}
}
