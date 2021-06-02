package com.crm.comcast.contacts_2;

import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateNewContactPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;

public class CancelButtonEnabledOrNot extends BaseClass
{
	@Test(groups = { "regressionTest"})
	public void createContactTest() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		String lastName=eLib.getExcelData("contact", 1, 2);
		String mailID=eLib.getExcelData("contact", 1, 3);
		 
		 
		HomePage hp=new HomePage(driver);
		hp.navigateContacts();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.createContactLink();
		
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.createContact(lastName, mailID);
		cnc.cancelButtonEnableOrNot();
		cnc.cancelBtn();
		
	}
}
