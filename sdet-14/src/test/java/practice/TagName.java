package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TagName 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		String nTag = eLib.getExcelData("contact", 1, 5);
		String lastName=eLib.getExcelData("contact", 1, 2);
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123456");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		
		//4.naviagate to "contact module" and click on create mail merge templates
		driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']")).click();
		
		driver.findElement(By.xpath("//input[@name='binFile']/following-sibling::input")).click();
		
		
	}
}
