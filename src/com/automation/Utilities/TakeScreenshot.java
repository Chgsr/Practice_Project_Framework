package com.automation.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.BaseTest.BaseTest;

public class TakeScreenshot extends BaseTest {
	
	private static File Img;
	
	
	public static void Takescreenshot(String Name) throws IOException {
		
		TakesScreenshot screenshot= (TakesScreenshot) getDriver();
		Img=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Img, new File(getDir()+"\\Screenshots\\"+Name+".jpeg"));
	}
	public static void Takescreenshot() throws IOException {
		
		TakesScreenshot screenshot= (TakesScreenshot) getDriver();
		Img=screenshot.getScreenshotAs(OutputType.FILE);
		String Dstfile= getDir()+"\\Screenshots\\"+getName()+".jpeg";
		FileUtils.copyFile(Img, new File(Dstfile));
	}
	
}

