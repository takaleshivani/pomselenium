package com.zoho.pages.session.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.pages.session.ZohoBaseSessionPage;

public class NewLeadPage extends ZohoBaseSessionPage {
	
	@FindBy(xpath=Constants.LEAD_COMPANY)
	public WebElement leadComapny;
	
	@FindBy(xpath=Constants.LEAD_NAME)
	public WebElement leadName;
	
	@FindBy(xpath=Constants.LEAD_SAVE_BUTTON)
	public WebElement savebutton;
	
	public LeadDetailsPage submitDetails(String comapnyName,String lName)
	{
		System.out.println("Creating Lead---"+comapnyName+"------"+lName);
		log("Creating Lead---"+comapnyName+"------"+lName);
		leadComapny.sendKeys(comapnyName);
		leadName.sendKeys(lName);
		savebutton.click();
		return new LeadDetailsPage();
	}
}
