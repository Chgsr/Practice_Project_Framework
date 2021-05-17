package com.automation.BaseTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Utilities.ScreeshotUtility;
import com.automation.Utilities.TakeScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.Getter;


public class BaseTest {
	
	 private static WebDriver driver;
	 private static String Dir;
	 private static ExtentReports extentreports;
	 private static ExtentTest extenttest;
	 private static String Name;
	
	
	
	public void Initialization() {
		
		Dir=System.getProperty("user.dir");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Parameters("Browsername")
	@BeforeSuite
	public void Openbrowser(@Optional("chrome") String Browsername)
	{
		
		if(Browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Initialization();
		}
		else if(Browsername.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Initialization();
		}
		else if(Browsername.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			Initialization();
		}
		else if(Browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Initialization();
		}
		
	}
	@AfterSuite
	public void closebrowser() throws FrameworkExceptions {

		if(driver!=null)
		{
			driver.quit();
			extenttest.log(LogStatus.INFO, "Browser Closed Successfully");
		}
		else
		{
			System.out.println(" Null Pointer Exception ");
			FrameworkExceptions FE= new FrameworkExceptions("Webdriver is Null");
			throw FE;
			
		}
	}
	
	@BeforeMethod
	public void Beforemethod(java.lang.reflect.Method method) {
		 String Mname=method.getName();
		System.out.println(" Test case Execution Started: "+Mname);
		extenttest=extentreports.startTest(Mname);
		extenttest.log(LogStatus.PASS, "Test Case Execution Started: "+Mname);
		}
	
	@AfterMethod
	public void Aftermethod(ITestResult result, Method method) throws IOException {
		
	 Name=result.getName();

		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.log(LogStatus.PASS, "Testcase Execution is Passed: "+Name);
			System.out.println(" Testcase Execution Is Success: "+Name);
			System.out.println(" Taking Screenshot");
			ScreeshotUtility.Takescreenshot(Name);
			
			

		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			
			
			System.out.println(" TestCase Execution is Failed: "+Name);
			System.out.println(" Taking Screenshot");
			TakeScreenshot.Takescreenshot(Name);
			extenttest.log(LogStatus.FAIL, "Testcase Execution is Failed and taken Screenshot: "+Name);
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			System.out.println(" TestCase Execution is Skipped: "+Name);
			System.out.println(" Taking Screenshot");
			TakeScreenshot.Takescreenshot(Name);
			extenttest.log(LogStatus.SKIP, "Testcase Execution is Skipped and taken Screenshot: "+Name);
		}
		extentreports.endTest(extenttest);
		extentreports.flush();
	}
	
	@BeforeTest
	public void InitReports() {
		
		extentreports = new ExtentReports(Dir+"\\Reports\\Reports.html");
		Map<String, String> map= new HashMap<>();
		map.put("user", "C H Gunashekar Reddy");
		map.put("Phone Num", "9392705090");
		extentreports.addSystemInfo(map);

	}
	
	@AfterTest
	public void GenerateReport() throws FrameworkExceptions {
		if(extentreports!=null) {
		extentreports.close();
		}
		else {
			FrameworkExceptions FE= new FrameworkExceptions("Extent Reports is Null");
			throw FE;
		}
	}

	
	public static String getDir() {
		return Dir;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static ExtentTest getExtenttest() {
		return extenttest;
	}

	public static String getName() {
		return Name;
	}
	
	
}
