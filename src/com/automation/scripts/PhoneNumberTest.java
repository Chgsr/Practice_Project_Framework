package com.automation.scripts;

import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;
import com.automation.Utilities.RegEx_PhoneNum_Validation;
import com.relevantcodes.extentreports.LogStatus;

public class PhoneNumberTest extends BaseTest {

	@Test
	public void phoneNumber() {
		
		
		boolean result;
		
		
		 result=RegEx_PhoneNum_Validation.IsValidPhoneNum("+918463904595");
		 getExtenttest().log(LogStatus.PASS, "Valid Phone Number: "+result);
		 result=RegEx_PhoneNum_Validation.IsValidPhoneNum("919392705090");
		 getExtenttest().log(LogStatus.PASS, "Valid Phone Number: "+result);
		 result=RegEx_PhoneNum_Validation.IsValidPhoneNum("09110704827");
		 getExtenttest().log(LogStatus.PASS, "Valid Phone Number: "+result);
		 result=RegEx_PhoneNum_Validation.IsValidPhoneNum("917097040395");
		 getExtenttest().log(LogStatus.PASS, "Valid Phone Number: "+result);
		 result=RegEx_PhoneNum_Validation.IsValidPhoneNum("+918184814342");
		 getExtenttest().log(LogStatus.PASS, "Valid Phone Number: "+result);
		
		
		
		
	}
	
}
