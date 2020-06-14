package com.zoho.pages.components.common.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBase;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.session.contacts.Contacts;
import com.zoho.pages.session.contacts.NewContacts;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.pages.session.lead.NewLeadPage;

public class Header {
	
	@FindBy(xpath=Constants.ADD_ICON)
	public WebElement addIcon;
	@FindBy(xpath=Constants.SUB_LEAD_HEADER)
	public WebElement submenuleads;
	@FindBy(xpath=Constants.SUB_CONTACT_HEADER)
	public WebElement submenucontacts;
	
	@FindBy(xpath=Constants.LEAD_HEADER)
	public WebElement lead;
	
	@FindBy(xpath=Constants.CONTACT_HEADER)
	public WebElement contact;
	
	public Header(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void logout()
	{
		
	}
	public ZohoPage create(String text)
	{
		try {
			Thread.sleep(2000);
			addIcon.click();
			if(text.equals("lead"))
			{
				submenuleads.click();
				return new NewLeadPage();
			}else if(text.equals("contacts"))
			{
				submenucontacts.click();;
				return new NewContacts();
			}
		}
		catch(Exception e)
		{
			
		}
		return new ZohoBase();
	}
	
	public ZohoPage delete(String text)
	{
		try {
			Thread.sleep(2000);
			if(text.equals("lead"))
			{
				lead.click();
				return new LeadsPage();
			}else if(text.equals("contacts"))
			{
				contact.click();
				return new Contacts();
			}
		}
		catch(Exception e)
		{
			
		}
		return new ZohoBase();
	}
	
	public ZohoPage gotoLead()
	{
		submenuleads.click();
		return new LeadsPage();
	}
	
	public ZohoPage gotoContacts()
	{
		submenucontacts.click();
		return new Contacts();
	}
}
