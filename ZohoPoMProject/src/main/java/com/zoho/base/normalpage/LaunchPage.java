package com.zoho.base.normalpage;

import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBase;
import com.zoho.base.pages.ZohoPage;
import com.zoho.base.session.ZohoTestSession;

public class LaunchPage extends ZohoBase{

	public LaunchPage()
	{
		System.out.println("------LaunchPage constructor-------------");
	
	}
	public ZohoPage openBrowser(String browser)
	{
		//ZohoTestSession session=getSession();
		getDriver().opneBrowser("browser");
		return this;
	}

	public ZohoPage gotoHomePage() {
		// TODO Auto-generated method stub
		System.out.println("----Opening Launch Page----");
		getDriver().navigate("https://www.zoho.com/");
		return new HomePage();
	}

}
