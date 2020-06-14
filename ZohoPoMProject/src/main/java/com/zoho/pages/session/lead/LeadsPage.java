package com.zoho.pages.session.lead;


import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.session.DefaultLandingPage;
import com.zoho.pages.session.ZohoBaseSessionPage;

public class LeadsPage extends ZohoBaseSessionPage{
	
	
	public ZohoPage deleteLead(String leadName,String leadCompany)
	{
		//check if lead is already existed---if yes->delete ---if No->Disply lead is not present 
		
		return new DefaultLandingPage();
	}
}
