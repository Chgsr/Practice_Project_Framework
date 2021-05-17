package com.automation.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;

public class PopUpsTest extends BaseTest{
	
	@Test
	public void POPUP() throws InterruptedException {


		JavascriptExecutor JE= (JavascriptExecutor) getDriver();
		
		getDriver().get("https://www.tsrtconline.in/oprs-web/");
			
			WebElement btn= getDriver().findElement(By.id("searchBtn"));
			
			JE.executeScript("arguments[0].click();", btn);
			
			Alert alert= getDriver().switchTo().alert();
			
			Thread.sleep(3000);
			
			alert.accept();
			
			
			
			
	}
	
}

