package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxTest {
	
	

		@Parameters("Name")
		@Test
		public void FireFox(String Name) {
			
			System.out.println(Name);

			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			
			driver.get("http://www.demo.guru99.com/V4/");
			
			driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr325816");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("UnynEbU");
			driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
			
			
		}
	}


