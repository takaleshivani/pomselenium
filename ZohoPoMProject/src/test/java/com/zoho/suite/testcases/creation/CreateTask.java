package com.zoho.suite.testcases.creation;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zoho.base.normalpage.LaunchPage;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.dataProvider.TestDataProvider;
import com.zoho.suite.base.TestBase;
import com.zoho.util.DataUtil;

public class CreateTask extends TestBase{
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="getData")
	public void createLeadTest(Hashtable<String, String> data)
	{
		session.log(data.toString());
		if(data.get("RunMode").equals("N") && !DataUtil.isRunnable(xls, testName)) {
			session.skipTest("Skipping test case as RunMode as N");
			throw new SkipException("Skipping test case as RunMode as N");
		}
	
		
		session.end();
	}
}
