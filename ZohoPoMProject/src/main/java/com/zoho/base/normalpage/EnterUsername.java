package com.zoho.base.normalpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBase;
import com.zoho.base.pages.ZohoPage;

public class EnterUsername extends ZohoBase{
	
	@FindBy(xpath=Constants.LOGIN_ID)
	WebElement loginusername;
	
	@FindBy(xpath=Constants.Next_Button)
	WebElement next_button;
	
	public ZohoPage submitUsername(String userid)
	{
		loginusername.sendKeys(userid);
		next_button.click();
		boolean presence=validator(true).isElementPresent(Constants.Password_Locator);
		System.out.println("Cheking presence-------"+presence);
		if(!presence)
			return this;
		else 
			return new EnterPassword();
	}
	
	
}
