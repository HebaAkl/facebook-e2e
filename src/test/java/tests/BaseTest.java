package tests;


import driver_manager.DriverManager;
import driver_manager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Helper;

public class BaseTest {

	public static WebDriver driver;
	DriverManager driverManager;
	
	@BeforeMethod
	public void startDriver(){
		driverManager = DriverManagerFactory.getManager(DriverManagerFactory.DriverType.CHROME);
		driver = driverManager.getDriver();
	}
	
	@AfterMethod
	public void stopDriver(){
		driverManager.quitDriver();
	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
}
