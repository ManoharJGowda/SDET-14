package com.crm.comcast.contacts_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_33_CancelButtonIsEnableRNot extends BaseClass
{
	@Test(groups = {"regressionTest"})
	public void cancelButton() throws Throwable
	{		
		/*read test script data*/
		 String lastName=eLib.getExcelData("contact", 1, 2);
		 String mailID=eLib.getExcelData("contact", 1, 3);
		 String nTag = eLib.getExcelData("contact", 1, 5);
		  
		//3.Place the mouse cursor and click on "Contact" Link
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			
		//4.naviagate to "create new Contact"page by click on "+" image
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		//5.Create a contact with all mandatory fields and click on cancel
		WebElement typeTag = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		wLib.select(typeTag, nTag);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		WebElement canclBTN = driver.findElement(By.xpath("(//input[@name='button'])[2]"));
		if(canclBTN.isEnabled())
			System.out.println("Cancel button is enabled");
		else
			System.out.println("cancel button is disabled");
		canclBTN.click();
		
		//verify contacts page
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		
	}
}
