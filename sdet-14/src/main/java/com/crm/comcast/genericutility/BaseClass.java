package com.crm.comcast.genericutility;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

	public class BaseClass {


		
		 /* crate Object for Utility*/
		 public PropertyFileUtility pLib = new PropertyFileUtility();
		 public ExcelUtility eLib = new ExcelUtility();
		 public WebDriverUtility wLib = new WebDriverUtility();
		 public DatabaseUtility db = new DatabaseUtility();
		 public WebDriver driver;
		 public static WebDriver staticDriver;


		 @BeforeSuite(groups = {"smokeTest" , "regressionTest"}) 
		 public void beforeSuite() 
		 {
		  
		 db.connectToDB();
		  System.out.println("===========Connect to DB============");
		  System.out.println("=========Report Creation============");
		 }

		// @Parameters("browser")
		 @BeforeClass(groups = {"smokeTest" , "regressionTest"})
		 public void launchBrowser() throws Throwable 
		 {
			 String BROWSER = pLib.readDataFromPropertyFfile("browser");
		  if(BROWSER.equalsIgnoreCase("firefox")) {
		   driver = new FirefoxDriver();
		  }else if(BROWSER.equalsIgnoreCase("chrome")) {
		   driver = new ChromeDriver();
		  }else if(BROWSER.equalsIgnoreCase("ie")) {
		   driver = new InternetExplorerDriver();

		  }
		 }

		 @BeforeMethod(groups = {"smokeTest" , "regressionTest"})
		 public void logintoApplication() throws Throwable
		 {
		  String USERNAME = pLib.readDataFromPropertyFfile("username");
		  String PASSWORD = pLib.readDataFromPropertyFfile("password");
		  String URL = pLib.readDataFromPropertyFfile("url");

		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		 }

		 @AfterMethod(groups = {"smokeTest" , "regressionTest"})
		 public void logoutApplication() {
		WebElement lgt = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wLib.mouseOver(driver, lgt);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		 }

		 @AfterClass(groups = {"smokeTest" , "regressionTest"})
		 public void closeBrowser() 
		 {
		  driver.close();
		 }

		 @AfterSuite(groups = {"smokeTest" , "regressionTest"})
		 public void closeDBConnection() throws SQLException 
		 {
		  db.closeDB();
		  System.out.println("===========Close Connection to DB============");
		 }



}
