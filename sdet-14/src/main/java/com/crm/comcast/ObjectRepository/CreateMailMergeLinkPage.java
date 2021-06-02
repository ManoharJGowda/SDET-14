package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateMailMergeLinkPage extends WebDriverUtility
{
	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	
	public  CreateMailMergeLinkPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/table[2]/tbody/tr/td/table[2]/tbody/tr[1]/td[2]/strong/input[1]")
	private WebElement chooseFile;
	
	@FindBy(xpath="//select[@name='target_module']")
	private WebElement targetModule;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveBTN;
	
	
	public void createMailMerge(String filePath)
	{
		chooseFile.sendKeys(filePath);
	}
	public void targetModule(String module)
	{
		wLib.select(targetModule, module);
		//targetModule.sendKeys(module);
	}
	public void clickSave()
	{
		saveBTN.click();
	}
	public void acceptAlert(WebDriver driver) 
	{
		String alrt = driver.switchTo().alert().getText();
		String actAlrt="Specify a File to Merge";
		System.out.println();
		super.acceptAlert(driver);
	}
}
