package com.zoho.suite.base;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.zoho.base.session.ZohoTestSession;
import com.zoho.util.Xls_Reader;
	

public class TestBase{
	public ZohoTestSession session;
	public String testName=null;
	public Xls_Reader xls=new Xls_Reader("C:\\Users\\Asus\\eclipse-workspace\\ZohoPoMProject\\Data.xlsx");
	
	@BeforeMethod
	public void init(ITestResult result)
	{
		testName=result.getMethod().getMethodName().toUpperCase();
		session=new ZohoTestSession();
		session.init(testName);
		
		
	}
	
	@AfterMethod
	public void quit()
	{
		session.generateReport();
	}
}
