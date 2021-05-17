package com.automation.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegEx_PhoneNum_Validation {
	
	public static boolean IsValidPhoneNum(String PhoneNum)
	{
		boolean ValidorInvalid;
		Pattern pattern= Pattern.compile("(0|[+]?91)?[6-9][0-9]{9}");
		
		Matcher matcher= pattern.matcher(PhoneNum);
		
		if(matcher.find()&&matcher.group().equalsIgnoreCase(PhoneNum))
		{
			ValidorInvalid= true;
			//BaseTest.getExtenttest().log(LogStatus.PASS, "Phone Number is Valid:"+PhoneNum);
			System.out.println(" Valid Phone Number: "+PhoneNum);
		}
		else
		{
			//BaseTest.getExtenttest().log(LogStatus.FAIL, " Phone Number is Invalid: "+PhoneNum);
			System.out.println(" INValid Phone Number: "+PhoneNum);
			ValidorInvalid= false;
		}
		return ValidorInvalid;
	}

}
