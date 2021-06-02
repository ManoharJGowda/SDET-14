package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(name="portal")
	private WebElement enblPortl;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	
	
	/**
	 * Ragvendra
	 * @param lastName
	 */
	public void createContact(String lastName ,String emailID) 
	{
		lastNameEdt.sendKeys(lastName);
		emailId.sendKeys(emailID);
		enblPortl.click();
		//saveBtn.click();
	
	}
	public void saveButtonEnablerNot()
	{
		if(saveBtn.isEnabled())
		{
			System.out.println("Save Button is Enabled");
		}
		else
		{
			System.out.println("Save button is disabled");
		}
		
		
	}
	public void saveButton()
	{
		saveBtn.click();
	}
	
	public void cancelButtonEnableOrNot()
	{
		if(cancelBtn.isEnabled())
		{
			System.out.println("Cancel Button is Enabled");
		}
		else
		{
			System.out.println("Cancel Button is Disabled");
		}
		
	}
	public void cancelBtn()
	{
		cancelBtn.click();
	}
		
		
	
	
		

	
}

