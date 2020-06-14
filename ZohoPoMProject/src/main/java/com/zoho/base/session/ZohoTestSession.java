package com.zoho.base.session;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;
import com.zoho.base.normalpage.LaunchPage;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.reports.ExtentManager;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoDriver;

import org.apache.commons.io.FileUtils;

public class ZohoTestSession {
	WebConnector conn;
	ZohoPage currentPage;
	public ExtentReports reports;
	public ExtentTest test;
	boolean executeListener;
	Xls_Reader xls;
	String testName;
	
	public boolean isExecuteListener() {
		return executeListener;
	}

	public void setExecuteListener(boolean executeListener) {
		this.executeListener = executeListener;
	}

	public ZohoPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(ZohoPage currentPage) {
		this.currentPage = currentPage;
	}

	public ZohoTestSession()
	{
		conn=new ZohoDriver();
	}
	
	public void init(String testName)
	{
		
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session")==null)
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		setTestName(testName);
		reports=ExtentManager.getInstance(Constants.REPORT_PATH);
		xls=new Xls_Reader("C:\\Users\\Asus\\eclipse-workspace\\ZohoPoMProject\\Data.xlsx");
		test=reports.createTest(testName);
		
		//getData();
		ZohoPage page=new LaunchPage();
		
	}


	private void setTestName(String testN) {
		// TODO Auto-generated method stub
	testName=testN;
	}

	public void skipTest(String message)
	{
		test.log(Status.SKIP, message);
	}
	public WebConnector getConn()
	{
		return conn;
	}

	public void end() {
		// TODO Auto-generated method stub
		getConn().assertAll();
		
	}
	public void generateReport() {
		reports.flush();
	}
	public void log(String message)
	{
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	public void failTest(String message)
	{
		//takeScreenshot();
		test.log(Status.FAIL, message);
	}
	public void takeScreenshot()
	{
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		try {
			File srcFile=((TakesScreenshot)getConn().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*@DataProvider
	public Object[][] getData()
	{	
		System.out.println("Inside data Provider");
	//	Xls_Reader xls=new Xls_Reader("C:\\Users\\Asus\\eclipse-workspace\\HybridFramework_Apr2020\\Hybrid_data.xlsx");
		//init();
		System.out.println(xls);
		return DataUtil.getTestData(xls, testName);
	}*/
}
