package com.automation.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	@Test(dataProvider = "Data")
	public void Display(String Name, int Age, int Weight) {

		System.out.println(Name+ "******"+Age+"*******"+Weight);
	}
	
	@DataProvider
	public Object[][] Data()
	{
		Object[][] data= new Object[3][3];
		data[0][0]="Gunashekar";
		data[0][1]=25;
		data[0][2]=84;
		data[1][0]="Tulasi Ram ";
		data[1][1]=21;
		data[1][2]=79;
		
		 data[2][0]= "varaPrasad"; data[2][1]= 29; data[2][2]=80;
		return data;
	}

}
