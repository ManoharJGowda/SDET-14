package com.crm.comcast.contacts_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_34_CreateMailMergeTemplateWithOrganition extends BaseClass
{
	@Test(groups = {"smokeTest"})
	public void createMergeMailTemplate() throws Throwable 
	{		
		/*read test script data*/
		 String lastName=eLib.getExcelData("contact", 1, 2);
		 String mailID=eLib.getExcelData("contact", 1, 3);
		 String module=eLib.getExcelData("contact", 1, 4);
		 String nTag = eLib.getExcelData("contact", 1, 5);
		  
		//3.Place the mouse cursor and click on "Contact" Link
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
		//4.naviagate to "contact module" and click on create mail merge templates
		driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']")).click();
		
		//5.choose template file click on choose files
		WebElement file = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table[2]/tbody/tr[1]/td[2]/strong/input[1]"));
				
		//6.select source file 
		file.sendKeys("C:\\Users\\Manujayaram\\Downloads\\ChatLog_SDET_1_ Batch.rtf");
		
		//7.select module as organization and click on save
		WebElement target = driver.findElement(By.xpath("//select[@name='target_module']"));
		wLib.select(target, module);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		//verify
		String actualTitle = driver.findElement(By.xpath("//td[text()='Module']/../..")).getText();
		//System.out.println(actualTitle);
		if(actualTitle.contains(module))
			System.out.println("mail Have Created succesfully as "+ module);
		else
			System.out.println("mail is not created as " + module);
		
		
	}
}
