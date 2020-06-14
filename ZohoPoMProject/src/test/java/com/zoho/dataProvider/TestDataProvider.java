package com.zoho.dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;

public class TestDataProvider {
	
	//static Xls_Reader xls=;
	@DataProvider
	public Object[][] getData(Method m)
	{	
		System.out.println("Inside data Provider");
		System.out.println("Getting data for--"+m.getName());
		Object[][]data=new DataUtil().getTestData(new Xls_Reader("C:\\Users\\Asus\\eclipse-workspace\\ZohoPoMProject\\Data.xlsx"), m.getName());
		System.out.println("Got data for--"+m.getName());
		//init();
		//System.out.println(xls);
		return data;
	}
}
