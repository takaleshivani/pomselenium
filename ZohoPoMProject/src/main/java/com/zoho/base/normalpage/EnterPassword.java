package com.zoho.base.normalpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBase;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.session.IntermediatePage;

public class EnterPassword extends ZohoBase{
	
	@FindBy(xpath=Constants.Password_XPATH)
	WebElement loginpassword;
	
	@FindBy(xpath=Constants.Next_Button)
	WebElement next_button;
	
	public ZohoPage submitPassword(String userid)
	{
		loginpassword.sendKeys(userid);
		next_button.click();
		return new IntermediatePage();
	}
}
