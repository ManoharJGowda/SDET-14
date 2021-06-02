package com.crm.comcast.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_33_CancelButtonIsEnableRNot 
{
	public static void main(String[] args) throws Throwable 
	{
		/*create object to Utility*/
		 PropertyFileUtility pLib = new PropertyFileUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 WebDriverUtility wLib = new WebDriverUtility();
		
		
		/*read common data*/
		 
		 String BROWSER = pLib.readDataFromPropertyFfile("browser");
		 String USERNAME = pLib.readDataFromPropertyFfile("username");
		 String PASSWORD = pLib.readDataFromPropertyFfile("password");
		 String URL = pLib.readDataFromPropertyFfile("url");

		
		/*read test script data*/
		 String lastName=eLib.getExcelData("contact", 1, 2);
		 String mailID=eLib.getExcelData("contact", 1, 3);
		 String nTag = eLib.getExcelData("contact", 1, 5);
		 
		 
		 /*step 1 : login to app*/
		 WebDriver driver = null;
		   if(BROWSER.equalsIgnoreCase("firefox")) {
		       driver = new FirefoxDriver();
	      }else if(BROWSER.equalsIgnoreCase("chrome")) {
	    	   driver = new ChromeDriver();
	      }else if(BROWSER.equalsIgnoreCase("ie")) {
	    	   driver = new InternetExplorerDriver();
	      }
		  wLib.waitforPageToLoad(driver);
	      driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		//3.Place the mouse cursor and click on "Contact" Link
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			
		//4.naviagate to "create new Contact"page by click on "+" image
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
		//5.Create a contact with all mandatory fields and click on cancel
		WebElement typeTag = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		wLib.select(typeTag, nTag);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		WebElement canclBTN = driver.findElement(By.xpath("(//input[@name='button'])[2]"));
		if(canclBTN.isEnabled())
		{
			System.out.println("Cancel button is enabled");
		}
		else
		{
			System.out.println("cancel button is disabled");
		}
		canclBTN.click();
		
		//verify contacts page
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		if(expectedTitle.contains("Contacts"))
		{
			System.out.println("Contacts page is Dispalyed");
		}
		else
		{
			System.out.println("Contacts page is Not displayed");
		}
		
		//6.Logout
		WebElement lgt = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wLib.mouseOver(driver, lgt);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}
}
