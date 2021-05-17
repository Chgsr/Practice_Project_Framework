package com.automation.Pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.automation.BaseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;


public class Opencart_Laptop_Notebooks extends BaseTest {
	
	private static Actions actions;
	private static Select select;
	
	
	
	static
	{
		PageFactory.initElements(getDriver(), Opencart_Laptop_Notebooks.class);
	}

	
	@FindBy(xpath = "//a[text()='Login']")
	private static WebElement Login;
	
	@FindBy(id = "input-email")
	private static WebElement Email;
	
	@FindBy(id = "input-password")
	private static WebElement Password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private static WebElement ClickLogin;
	
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	private static WebElement Laptop_Notebook;
	
	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	private static WebElement Show_All_Laptop_Books;
	
	@FindBy(id = "input-sort")
	private static WebElement SortBy;
	
	@FindBy(xpath = "//select[@id='input-sort']/option[2]")
	private static WebElement SelectAtoZ;
	
	@FindBy(xpath = "//select[@id='input-sort']/option[3]")
	private static WebElement SelectZtoA;
	
	@FindBy(xpath = "//div[@class='row']//h4/a")
	private static List<WebElement> Lpatopnames;
	
	public static void Click_Login() {

		SoftAssert Sassert = new SoftAssert();
		
		Sassert.assertTrue(Login.isEnabled()&&Login.isDisplayed());
		getExtenttest().log(LogStatus.PASS, "Login Button is Enabled");
		Login.click();
		getExtenttest().log(LogStatus.PASS, "Clicked On Login");
				
		
	}
	
	public static void Enter_Email(String EnterEmail) {

		Email.clear();
		Email.sendKeys(EnterEmail);
		getExtenttest().log(LogStatus.PASS, "Email entered as: "+EnterEmail);
	}
	
	public static void Enter_Password(String EnterPassword) {

		Password.clear();
		Password.sendKeys(EnterPassword);
		getExtenttest().log(LogStatus.PASS, " Password Entered as: "+EnterPassword);
	}
	
	public static void ClickLogin() {

		assertTrue(ClickLogin.isEnabled()&&ClickLogin.isDisplayed());
		getExtenttest().log(LogStatus.PASS, " Login Button is Enabled");
		ClickLogin.click();
		getExtenttest().log(LogStatus.PASS, "Cliked On Login");
	}
	
	public static void MouseOver_Lpatops_Notebooks() {

		actions = new Actions(getDriver());
		
		if(Laptop_Notebook.isEnabled()&&Laptop_Notebook.isDisplayed())
		{
			getExtenttest().log(LogStatus.PASS, " Lptops and Notebooks butoon is enabled");
			actions.moveToElement(Laptop_Notebook).build().perform();
			getExtenttest().log(LogStatus.PASS, " Mouse over action done on Laptops and Notebooks");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, "unable to find Lpatops and Notebooks");
		}
	}
	
	public static void Click_showAll_Laptop_Notebooks() {

		if(Show_All_Laptop_Books.isEnabled()&&Show_All_Laptop_Books.isDisplayed())
		{
			getExtenttest().log(LogStatus.PASS, " Show all laptops and Notebooks button is enabled");
			Show_All_Laptop_Books.click();
			getExtenttest().log(LogStatus.PASS, " Clicked on Show all laptops and Notebooks" );
			
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, " Show all laptops and Notebooks button is Disbaled");
		}
	}
	
	public static void click_sortBy() {

		if(SortBy.isEnabled()&&SortBy.isDisplayed())
		{
			
			SortBy.click();
			getExtenttest().log(LogStatus.PASS, " Clicked on Sort By");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, " Sort by dropdown is disbled");
		}
	}
	
	public static void SelectAtoZ()
	{
		if(SelectAtoZ.isEnabled()&&SelectAtoZ.isDisplayed())
		{
			select= new Select(SortBy);
			select.selectByIndex(1);
			/* SelectAtoZ.click(); */
			getExtenttest().log(LogStatus.PASS, " Clicked on Select A to Z");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, " Select A to Z is not selected");
		}
	}
	
	public static void SelectZtoA()
	{
		if(SelectZtoA.isEnabled()&&SelectZtoA.isDisplayed())
		{
			select= new Select(SortBy);
			select.selectByIndex(2);
			/* SelectZtoA.click(); */
			getExtenttest().log(LogStatus.PASS, " Clicked on Select A to Z");
		}
		else
		{
			getExtenttest().log(LogStatus.FAIL, " Select A to Z is not selected");
		}
	}
	
	
	public static List<String> Total_LaptopNames_AtoZ() {

		List<String> lap = new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(Lpatopnames));
		for(WebElement element:Lpatopnames)
		{
			String txt=element.getText();
			lap.add(txt);
			getExtenttest().log(LogStatus.PASS, " Available Laptops are: "+txt);
		}
		
		getExtenttest().log(LogStatus.PASS, " All laptops are: "+lap);
		return lap;
	}
	
	
}
