package com.automation.Utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.automation.BaseTest.BaseTest;
import com.automation.supporters.ExcelReader;
import com.automation.supporters.PropertiesReader;

public class POJO_Utility {

	private static String OrPath= BaseTest.getDir()+"\\src\\com\\automation\\ObjectRepository\\OR_Practice.properties";
	private static String ConfPath= BaseTest.getDir()+"\\Conf_Practice.properties";
	private static String Excelpath= BaseTest.getDir()+ "\\src\\com\\automation\\Testdata\\Book1.xlsx";
	
	public static PropertiesReader GetOr() throws IOException {

		PropertiesReader OrPr= new PropertiesReader(OrPath);
		return OrPr;
	}
	
	public static PropertiesReader GetConf() throws IOException {

		PropertiesReader OrConf= new PropertiesReader(ConfPath);
		return OrConf;
	}
	
	public static ExcelReader GetexcelReader() throws EncryptedDocumentException, IOException
	{
		ExcelReader excel = new ExcelReader(Excelpath);
		return excel;
	}
	
}
