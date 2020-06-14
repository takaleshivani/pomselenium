package com.zoho.suite.testcases.login;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.normalpage.EnterPassword;
import com.zoho.base.normalpage.EnterUsername;
import com.zoho.base.normalpage.LaunchPage;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.base.session.ZohoTestSession;
import com.zoho.dataProvider.TestDataProvider;
import com.zoho.listener.ZohoEventListener;
import com.zoho.reports.ExtentManager;
import com.zoho.suite.base.TestBase;
import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;
import com.zoho.web.ZohoDriver;
import com.zoho.web.ZohoValidationDriver;
import com.zoho.web.ZohoWebConnector;

public class LoginTest extends TestBase{
	
	/*ZohoTestSession session;
	String testName="LoginTest";
	@BeforeMethod
	public void init()
	{
		session=new ZohoTestSession();
		session.init(testName);
		
		
	}
	
	@AfterMethod
	public void quit()
	{
		session.generateReport();
	}*/
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="getData")
	public void loginTest(Hashtable<String, String> data)
	{
		session.log(data.toString());
		if(data.get("RunMode").equals("N")  && !DataUtil.isRunnable(xls, testName)) {
			session.skipTest("Skipping test case as RunMode as N");
			throw new SkipException("Skipping test case as RunMode as N");
		}
		String username=data.get("Username");
		String usernameValid=data.get("UsernameValid"); 
		String password=data.get("Password");
		ZohoPage page=new LaunchPage()
		.openBrowser("firefox")
		.gotoHomePage()
//		.validator().Display();
		.validator(false).validateTitle(Constants.HOME_PAGE_TITLE)///stop execution
//		.validator(true).validateText("yyy","Shivani")//dont have to stop
		.gotoEnterUsernamePage()
		.validator(true).validateElementPresence(Constants.LOGIN_ID_Locator)
		.submitUsername(username);
		
		if(page instanceof EnterUsername & usernameValid.equals("Y"))
		{
			//failure
			page.validator(true).fail("Could enter Login");
		}
		else if(page instanceof EnterPassword )
		{
			if(usernameValid.equals("N")) {
				page.validator(true).fail("Able to enter password");
			}
			else {
				page.submitPassword(password);
			}
				
		}
		
		session.end();
		/*EventFiringWebDriver driver=new EventFiringWebDriver(new FirefoxDriver());
		driver.register(new ZohoEventListener());
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.zoho.com/");
		driver.findElement(By.cssSelector("a.zh-login")).click();*/
	}
	
	/*@DataProvider
	public Object[][] getData()
	{	
		System.out.println("Inside data Provider");
		Xls_Reader xls=new Xls_Reader("C:\\Users\\Asus\\eclipse-workspace\\ZohoPoMProject\\Data.xlsx");
		//init();
		//System.out.println(xls);
		return DataUtil.getTestData(xls, testName);
	}*/
	
	
}
