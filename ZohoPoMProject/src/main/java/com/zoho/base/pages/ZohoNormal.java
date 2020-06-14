package com.zoho.base.pages;

import com.zoho.pages.session.lead.LeadDetailsPage;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.web.WebConnector;

public interface ZohoNormal {
	
	ZohoPage gotoHomePage();
	ZohoPage gotoEnterUsernamePage();
	void gotoRegisterPage();
	ZohoPage submitUsername(String userid);
	WebConnector validator(boolean b);
	ZohoPage submitPassword(String userid);
	ZohoPage validateIntermediatePageOptions();
	ZohoPage gotoDefaultLandingPage();
	LeadDetailsPage submitDetails(String comapnyName,String lName);
	LeadsPage gottoLeadPage();
	ZohoPage deleteLead(String leadName,String leadCompany);
}
