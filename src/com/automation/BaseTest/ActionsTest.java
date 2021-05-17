
package com.automation.BaseTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.automation.CustomisedExceptions.FrameworkExceptions;
import com.relevantcodes.extentreports.LogStatus;

abstract public class ActionsTest extends BaseTest {
	
	private static Actions actions;
	
	public static void Click(WebElement element) throws FrameworkExceptions {

		if(element!=null)
		{
			element.click();
			getExtenttest().log(LogStatus.PASS, "Cliked on Webelement"+element);
		}
		else
		{
			FrameworkExceptions FW = new FrameworkExceptions("Element having Null Value");
			throw FW;
		}
		
	}
	
	public static void Actions_Click(WebElement element) throws FrameworkExceptions {
		
		if(element!=null)
		{
			actions = new Actions(getDriver());
			actions.click(element).build().perform();
		}
		else
		{
			FrameworkExceptions FW = new FrameworkExceptions("Element having Null Value");
			throw FW;
		}
	}
	
	public static void DoubleClick(WebElement element) throws FrameworkExceptions {

		if(element!=null)
		{
			actions.doubleClick(element).build().perform();
		}
		else
		{
			FrameworkExceptions FW = new FrameworkExceptions("Element having Null Value");
			throw FW;
		}
	}
	
	public static void RightClick(WebElement element) throws FrameworkExceptions {
		
		if(element!=null)
		{
			actions.contextClick(element).build().perform();
		}
		else
		{
			FrameworkExceptions FW = new FrameworkExceptions("Element having Null Value");
			throw FW;
		}
	}
	
	
	

}
