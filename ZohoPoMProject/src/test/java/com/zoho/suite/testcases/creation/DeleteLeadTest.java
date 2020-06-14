package com.zoho.suite.testcases.creation;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.base.normalpage.LaunchPage;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.base.session.ZohoTestSession;
import com.zoho.dataProvider.TestDataProvider;
import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;

public class DeleteLeadTest {
	ZohoTestSession session;
	String testName="DeleteLeadTest";
	Xls_Reader xls=new Xls_Reader("C:\\Users\\Asus\\eclipse-workspace\\ZohoPoMProject\\Data.xlsx");
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
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="getData")
	public void deleteLeadTest(Hashtable<String, String> data)
	{
		session.log(data.toString());
		if(data.get("RunMode").equals("N") && !DataUtil.isRunnable(xls, testName)) {
			session.skipTest("Skipping test case as RunMode as N");
			throw new SkipException("Skipping test case as RunMode as N");
		}
		String username="shivanitakale10@gmail.com";
		String password="Fast@1104";
		ZohoPage page=new LaunchPage()
		.openBrowser("firefox")
		.gotoHomePage()
		.validator(false).validateTitle(Constants.HOME_PAGE_TITLE)///stop execution
		.gotoEnterUsernamePage()
		.validator(true).validateElementPresence(Constants.LOGIN_ID_Locator)
		.submitUsername(username)
		.submitPassword(password)
		.validateIntermediatePageOptions()
		.gotoDefaultLandingPage()
		.getHeader().delete("lead")
		.deleteLead(data.get("Lead_Name"), data.get("Lead_Company"));
		
		
		session.end();
	}
	
	/*@DataProvider
	public Object[][] getData()
	{	
		System.out.println("Inside data Provider");
		
		//init();
		//System.out.println(xls);
		return DataUtil.getTestData(xls, testName);
	}*/
}
