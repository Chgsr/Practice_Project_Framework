package com.automation.opencartTestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automation.BaseTest.BaseTest;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.automation.Pageobjects.Opencart_Laptop_Notebooks;
import com.automation.Pageobjects.Opencart_registration;
import com.automation.Utilities.POJO_Utility;

public class Opencart_LaptopNotebooks_AtoZ extends BaseTest {
	
	
	@Test
	public void All_Lpatop_notebooks_in_AscendingOrder() throws IOException, FrameworkExceptions {

		Opencart_registration.Navigation(POJO_Utility.GetConf().GetPropertyValue("Opencart_URL"));
		Opencart_registration.Click_My_Account();
		Opencart_Laptop_Notebooks.Click_Login();
		Opencart_Laptop_Notebooks.Enter_Email(POJO_Utility.GetexcelReader().GetCellValue("Index", "0", 0, 0));
		Opencart_Laptop_Notebooks.Enter_Password(POJO_Utility.GetConf().GetPropertyValue("OPencart_password"));
		Opencart_Laptop_Notebooks.ClickLogin();
		Opencart_Laptop_Notebooks.MouseOver_Lpatops_Notebooks();
		Opencart_Laptop_Notebooks.Click_showAll_Laptop_Notebooks();
		Opencart_Laptop_Notebooks.click_sortBy();
		Opencart_Laptop_Notebooks.SelectAtoZ();
		Opencart_Laptop_Notebooks.Total_LaptopNames_AtoZ();
		
		
		
	}
	
	

}
