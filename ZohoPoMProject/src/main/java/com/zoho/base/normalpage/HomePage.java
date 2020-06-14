package com.zoho.base.normalpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBase;
import com.zoho.base.pages.ZohoPage;

public class HomePage extends ZohoBase {
	
	@FindBy(css=Constants.Login_Link)
	WebElement loginlink;
	
	public HomePage()
	{
		System.out.println("-------------Homepage constructor----------------");
		
	}
	public ZohoPage gotoEnterUsernamePage()
	{
		System.out.println("----Clicking into Login link--------");
		log("Going to UserName Page");
		loginlink.click();
		return new EnterUsername();
	}
}
