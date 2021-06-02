package com.crm.comcast.contacts_2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateMailMergeLinkPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;

public class MailMergeTemplateTest extends BaseClass
{

	@Test(groups = { "regressionTest"})
	public void MailMergeTemplate() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		String lastName=eLib.getExcelData("contact", 1, 2);
		String mailID=eLib.getExcelData("contact", 1, 3);
		String module=eLib.getExcelData("contact", 1, 4);
		String nTag = eLib.getExcelData("contact", 1, 5);
		String file=eLib.getExcelData("contact", 1, 6);
		
		HomePage hp=new HomePage(driver);
		hp.navigateContacts();
		
		ContactsPage cp=new ContactsPage(driver);
		//cp.createContactLink();
		
		cp.createMailMergeLink();
		
		CreateMailMergeLinkPage cmm=new CreateMailMergeLinkPage(driver);
		cmm.targetModule(module);
		cmm.clickSave();
		cmm.acceptAlert(driver);
		
	}
}
