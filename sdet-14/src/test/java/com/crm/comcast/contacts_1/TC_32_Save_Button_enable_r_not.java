package com.crm.comcast.contacts_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_32_Save_Button_enable_r_not extends BaseClass
{
	@Test (groups = { "regressionTest"})
	public void saveButtonEnbale() throws Throwable
	{
		/*read test script data*/
		 String lastName=eLib.getExcelData("contact", 1, 2);
		 String mailID=eLib.getExcelData("contact", 1, 3);
		 String nTag = eLib.getExcelData("contact", 1, 5);
		 
		  
		//3.Place the mouse cursor and click on "Contact" Link
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			
		//4.naviagate to "create new Contact"page by click on "+" image
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		//5.Create a contact with mandatory fields and make "Portal user"box enabled
		WebElement typeTag = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		wLib.select(typeTag, nTag);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mailID);
		driver.findElement(By.xpath("//input[@name='portal']")).click();
		WebElement saveBTN = driver.findElement(By.xpath("(//input[@name='button'])[3]"));
		if(saveBTN.isEnabled())
			System.out.println("Save Button is enabled");
		else
			System.out.println("Save button is not enabled");
		saveBTN.click();
		String actualTitle = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(actualTitle);
		//verify
		//Assert.assertEquals(actualTitle, nTag);
		
		
	}

}
