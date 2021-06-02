package com.crm.comcast.genericutility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * 
 * @author Nitheesha
 *
 */
public class ListnersIMP implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			WebDriverUtility theWebdriverUtility = new WebDriverUtility();
			String screenshotName=result.getMethod().getMethodName()+JavaUtility.getSystemDate();
			theWebdriverUtility.takeScreenshot(BaseClass.staticDriver, screenshotName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
