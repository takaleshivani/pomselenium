package com.zoho.util;

import java.util.Hashtable;

import org.testng.annotations.Test;


public class DataUtil {
	
	/*@Test(dataProvider="getTestData")
	public void createLeadTest(Hashtable<String , String> data)
	{
		System.out.println("-------TestRunning----------");
	}
	*/

	public Object[][] getTestData(Xls_Reader xls,String testname)
	{
		//String testname="CreateLeadTest";
		//Xls_Reader xls=new Xls_Reader();
		int testStartRowNum=1;
		while(!xls.getCellData("Data", 0, testStartRowNum).equalsIgnoreCase(testname)) {
			testStartRowNum++;
		}
		//rowNumber of TestCase
		System.out.println("Test Starts from "+testStartRowNum);
		
		int colStartRowNum=testStartRowNum+1;
		int totalcols=0;
		while(!xls.getCellData("Data", totalcols, colStartRowNum).equals(""))
		{
			totalcols++;
		}
		//column of TestCase
		System.out.println("columns are "+totalcols);
		int dataStartRowNum=testStartRowNum+2;
		int totalRows=0;
		while(!xls.getCellData("Data", 0, dataStartRowNum).equals(""))
		{
			totalRows++;
			dataStartRowNum++;
		}
		System.out.println("Totals rows are "+totalRows);
		
		//read data
		dataStartRowNum=testStartRowNum+2;
		Hashtable<String, String> table=null;
		Object [][] myData=new Object[totalRows][1];
		int i=0;
		for(int rnum=dataStartRowNum;rnum<dataStartRowNum+totalRows;rnum++)
		{
			table=new Hashtable<>();
			for(int colnum=0;colnum<totalcols;colnum++)
			{
				String data=xls.getCellData("Data", colnum, rnum);
				String key=xls.getCellData("Data", colnum, colStartRowNum);
				System.out.println(key+"--"+data);
				table.put(key, data);
			}
			System.out.println(table);
			System.out.println("----------------------------");
			myData[i][0]=table;
			i++;
		}	
		return myData;
	}
	
	public static boolean isRunnable(Xls_Reader xls,String testCaseName)
	{
		String sheet="TestCases";
		
		for(int row=2;row<xls.getRowCount(sheet);row++)
		{
			if(xls.getCellData(sheet, "TCID", 2).equalsIgnoreCase(testCaseName))	
			{
				if(xls.getCellData(sheet, "RunMode", row).equals("Y"))
					return true;
				else 
					return false;
			}
		}
		return true;
	}
}
