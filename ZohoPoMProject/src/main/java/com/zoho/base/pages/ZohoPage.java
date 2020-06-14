package com.zoho.base.pages;

import com.zoho.base.session.ZohoTestSession;
import com.zoho.pages.components.common.session.Header;
import com.zoho.pages.session.lead.LeadDetailsPage;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.web.WebConnector;

public interface ZohoPage extends ZohoNormal,ZohoSessionPage{
	//will have general functionality of ZOho Page
	
	//normal browser applications
	ZohoPage openBrowser(String browser);
	void quit();
	void getTotalWindows();
	ZohoPage gotoEnterUsernamePage();
	
	//Zoho appliations
	ZohoPage gotoHomePage();
	void gotoRegisterPage();
	ZohoPage submitUsername(String userid);
	WebConnector validator(boolean b);
	ZohoPage submitPassword(String userid);
	Header getHeader();
	void waitForPageToLoad();
	LeadDetailsPage submitDetails(String comapnyName,String lName);
	LeadsPage gottoLeadPage();
	ZohoPage deleteLead(String leadName,String leadCompany);
	
	//zoho-session
	void createDeal();
	void logOut();
	
	ZohoTestSession getSession();
	void log(String message);
}
