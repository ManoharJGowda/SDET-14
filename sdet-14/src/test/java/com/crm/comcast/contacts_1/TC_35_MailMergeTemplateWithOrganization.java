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

public class TC_35_MailMergeTemplateWithOrganization extends BaseClass
{
	@Test(groups  ={"regressionTest"})
	public void mailMergeTemplate() throws Throwable
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
		
		
		//5.select module as organization and click on save
		WebElement target = driver.findElement(By.xpath("//select[@name='target_module']"));
		wLib.select(target, module);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		String alrt = driver.switchTo().alert().getText();
		String actAlrt="Specify a File to Merge";
		//System.out.println(alrt);
		wLib.acceptAlert(driver);
		
		//6.verify
		if(alrt.contains(actAlrt))
			System.out.println(alrt + " popup is displayed");
		else
			System.out.println(alrt + " popup will not displayed");
		
	}
}
