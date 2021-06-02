package com.crm.comcast.contacts_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;

public class TC_31_CreateContactTest extends BaseClass 
{
	@Test(groups = {"smokeTest"})
	public void createContact() throws Throwable
	{
		String lastName=eLib.getExcelData("contact", 1, 2);
		String mailID=eLib.getExcelData("contact", 1, 3);
		String nTag = eLib.getExcelData("contact", 1, 5);
		 
		//3.Place the mouse cursor and click on "Contact" Link
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
				
		//4.naviagate to "create new Contact"page by click on "+" image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//5.Create a contact with mandatory fields and make "Portal user"box enabled
		 WebElement typeTag = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		//typeTag.click();
		wLib.select(typeTag, nTag);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mailID);
		driver.findElement(By.xpath("//input[@name='portal']")).click();
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		String actualTitle = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(actualTitle);
		
		//verify
		if(actualTitle.contains(lastName))
			System.out.println(actualTitle + "Contact name created sucessfully");
		else
			System.out.println("Contact is not created");
		//Assert.assertEquals(actualTitle, lastName);
		
	}
}
