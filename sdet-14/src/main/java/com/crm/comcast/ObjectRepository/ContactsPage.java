package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.BaseClass;

public class ContactsPage extends BaseClass
{

	WebDriver driver;
	
	public ContactsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLink ;
	
	@FindBy(xpath="//a[text()='Create Mail Merge templates ']")
	private WebElement mailMergeLink;
	
	
	
	public void createContactLink()
	{
		 createContactLink.click();
	}
	
	public void createMailMergeLink()
	{
		mailMergeLink.click();
	}
	

	
	
	
}
