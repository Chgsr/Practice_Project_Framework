package com.automation.Pageobjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.automation.BaseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class Opencart_registration extends BaseTest {
	private static Actions actions;
	private static String password;
	private static String Cpassword;
	
	static
	{
		PageFactory.initElements(getDriver(), Opencart_registration.class);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private static WebElement My_Account;
	
	@FindBy(xpath = "//a[text()='Register']")
	private static WebElement Register;
	
	@FindBy(id = "input-firstname")
	private static WebElement Firstname;
	
	@FindBy(id = "input-lastname")
	private static WebElement Lastname;
	
	@FindBy(id = "input-email")
	private static WebElement Email;
	
	@FindBy(id = "input-telephone")
	private static WebElement TelephoneNum;
	
	@FindBy(id = "input-password")
	private static WebElement Password;
	
	@FindBy(id = "input-confirm")
	private static WebElement Confirm_Password;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private static WebElement Agree_CheckBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private static WebElement Continue;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private static WebElement Accntcreated;
	
	public static void  Click_My_Account() {

		SoftAssert assert1= new SoftAssert();
		assert1.assertTrue(My_Account.isEnabled()&&My_Account.isDisplayed());
		actions = new Actions(getDriver());
		actions.click(My_Account).build().perform();
		getExtenttest().log(LogStatus.PASS, "Clicked On My Account");
	}
	
	public static void Click_Register() {
		SoftAssert Sassert= new SoftAssert();
		Sassert.assertTrue(Register.isEnabled()&&Register.isDisplayed());
		actions.click(Register).build().perform();
		getExtenttest().log(LogStatus.PASS, "Clicked On Register");
		
	}
	
	public static void EnterFirstname(String FirstName) {

		Firstname.clear();
		getExtenttest().log(LogStatus.PASS, " Cleared on Firstname Filed");
		Firstname.sendKeys(FirstName);
		getExtenttest().log(LogStatus.PASS, "Entered First name As: "+FirstName);
	}
	
	public static void EnterLastname(String LastName) {

		Lastname.clear();
		getExtenttest().log(LogStatus.PASS, " Cleared on Lastname Filed");
		Lastname.sendKeys(LastName);
		getExtenttest().log(LogStatus.PASS, "Entered Last name As: "+LastName);
	}
	
	public static void Email(String EnterEmail) {

		Email.clear();
		getExtenttest().log(LogStatus.PASS, " Cleared on Email Filed");
		Email.sendKeys(EnterEmail);
		getExtenttest().log(LogStatus.PASS, "Entered Email  As: "+EnterEmail);
	}
	
	public static void PhoneNumber(String EnterMOBNum) {

		TelephoneNum.clear();
		getExtenttest().log(LogStatus.PASS, " Cleared on Telephone Filed");
		TelephoneNum.sendKeys(EnterMOBNum);
		getExtenttest().log(LogStatus.PASS, "Entered Phone Number  As: "+EnterMOBNum);
	}
	
	public static void Password(String EnterPassword) {

		Password.clear();
		getExtenttest().log(LogStatus.PASS, " Cleared on Password Filed");
		Password.sendKeys(EnterPassword);
		password=EnterPassword;
		getExtenttest().log(LogStatus.PASS, "Entered Password  As: "+EnterPassword);
		
	}
	
	public static void ConfirmPassword(String EnterCPassword) {

		Confirm_Password.clear();
		getExtenttest().log(LogStatus.PASS, "Cleared on Confirm Password Field");
		Confirm_Password.sendKeys(EnterCPassword);
		Cpassword=EnterCPassword;
		getExtenttest().log(LogStatus.PASS, " Entered Confirm Password as: "+EnterCPassword);
		
		
	}
	
	public static void AgreePolicies() {

		if(Agree_CheckBox.isDisplayed()&&Agree_CheckBox.isEnabled())
		{
			Agree_CheckBox.click();
			getExtenttest().log(LogStatus.PASS, " Accepted Privacy Policies of OpenCart");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, " Agreement Check box is Disbaled");
		}
	}
	
	public static void ClickonContinue() {
		
		if(password.equals(Cpassword))
		{
			getExtenttest().log(LogStatus.PASS, " Password and Confirm passwords are matching"+password+"*******"+Cpassword);
			Continue.click();
			getExtenttest().log(LogStatus.PASS, " Clicked On Continue Button");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, " Password and Confirm password is not matched");
		}
	}
	
	public static void Validate_Accnt_Created_Or_Not() {
		
		if(Accntcreated.isEnabled()&&Accntcreated.isDisplayed())
		{
			String MSG=Accntcreated.getText();
			if(MSG.equalsIgnoreCase("Your Account Has Been Created!"))
			{
				getExtenttest().log(LogStatus.PASS, " Account Created Successfully");
			}
			else
			{
				getExtenttest().log(LogStatus.FAIL, " Account Not Created");
			}
		}
	}
	
	public static void Navigation(String URL) {
		getDriver().get(URL);
		getExtenttest().log(LogStatus.PASS, " Entered URL is: "+URL);
	}
	
	
	
	}
