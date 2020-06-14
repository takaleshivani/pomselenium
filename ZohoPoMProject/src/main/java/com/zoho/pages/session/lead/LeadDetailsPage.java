package com.zoho.pages.session.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.pages.session.ZohoBaseSessionPage;

public class LeadDetailsPage extends ZohoBaseSessionPage{

	@FindBy(xpath=Constants.BACK_DETAILS)
	public WebElement leadBack;
	
	public void validateDetails()
	{
		
	}
	
	public LeadsPage gottoLeadPage()
	{
		leadBack.click();
		return new LeadsPage();
	}
}
