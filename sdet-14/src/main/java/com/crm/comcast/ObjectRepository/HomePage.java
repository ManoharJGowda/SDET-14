package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;
		
		//Step 2
	 public HomePage(WebDriver driver) {
		 this.driver = driver;
		  PageFactory.initElements(driver, this);
	 }
	 
	 //Step 3
	  @FindBy(xpath = "\"//img[@src='themes/softed/images/user.PNG']\"")
	  private WebElement administationImg;
	  
	  @FindBy(linkText = "Sign Out")
	  private WebElement signOutLnk;
	  
	  @FindBy(linkText = "Organizations")
	  private WebElement oraganizationsLnk;
	  
	  @FindBy(linkText = "Contacts")
	  private WebElement contactsLnk;
	  
	  @FindBy(linkText = "Opportunities")
	  private WebElement opportunitiesLnk;
	  
	  @FindBy(linkText = "Products")
	  private WebElement productsLnk;
	  
	  @FindBy(linkText = "Leads")
	  private WebElement leadsLnk;
	  
	  @FindBy(linkText = "More")
	  private WebElement moreLnk;
	  
	  @FindBy(linkText = "Purchase Order")
	  private WebElement purchaseOrderLnk;
	 //Step 4

	public WebElement getAdministationImg() {
		return administationImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public WebElement getOraganizationsLnk() {
		return oraganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getmoreLnk() {
		return moreLnk;
	}

	public WebElement getpurchaseOrderLnk()
	{
		return purchaseOrderLnk;
	}


	//Step 5
	public void logoutOfApp()
	{
		mouseOver(driver, administationImg);
		waitForElemnetToBeVisible(driver, signOutLnk);
		signOutLnk.click();
	}

	public void navigateOrg()
	{
		oraganizationsLnk.click();
	}

	public void navigateContacts()
	{
		contactsLnk.click();
	}

	public void navigateMore()
	{
		moreLnk.click();
		mouseOver(driver, moreLnk);
	}

	public void navigatePurchaseOrder()
	{
		purchaseOrderLnk.click();
	}
	
}
