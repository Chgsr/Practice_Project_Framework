package com.automation.Pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.BaseTest.BaseTest;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Utilities.POJO_Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Guru99_Login extends BaseTest {
	
	@FindBy(xpath = "//input[@name='uid']")
	private static WebElement Username;
	
	@FindBy(xpath = "//input[@name='password']")
	private static WebElement Password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	private static WebElement Login;
	
	@FindBy(xpath = "//td/marquee")
	private static WebElement ValidaeLogin;
	
	static
	{
		PageFactory.initElements(getDriver(), Guru99_Login.class);
	}
	
	public static void Enter_Username(String EnterUsername) {

		Username.clear();
		Username.sendKeys(EnterUsername);
		getExtenttest().log(LogStatus.PASS, "Username Entered As: "+EnterUsername);
	}
	public static void Enter_Password(String EnterPassword) {

		Password.clear();
		Password.sendKeys(EnterPassword);
		getExtenttest().log(LogStatus.PASS, "Username Entered As: "+EnterPassword);
	}
	
	public static void Click_Login() {

		assertTrue(Login.isEnabled()&&Login.isDisplayed());
		getExtenttest().log(LogStatus.PASS, "Login Button is Enabled");
		Login.click();
		getExtenttest().log(LogStatus.PASS, "Clicked On Login Button");
		
	}
	
	public static void Validate_Login() throws FrameworkExceptions {

		if(ValidaeLogin.isEnabled()&&ValidaeLogin.isDisplayed())
		{
			String LoginMessage=ValidaeLogin.getText();
			if(LoginMessage.equalsIgnoreCase("Welcome To Manager's Page of Guru99 Bank"))
			{
				getExtenttest().log(LogStatus.PASS, "Successfully Logged into the Guru99");
			}
			else
			{
				getExtenttest().log(LogStatus.FAIL, "Unable to Login Guru99");
				FrameworkExceptions FW= new FrameworkExceptions("Unable to Login Guru99");
				throw FW;
			}
				
		}
	}
	

}
