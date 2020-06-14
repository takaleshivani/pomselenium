package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector{
	void logout();
	ZohoPage validateTitle(String ExpectedTitle);
	ZohoPage validateLogin();
	ZohoPage validateText(String locator,String expectedText);
	
	ZohoPage Display();
	ZohoPage validateElementPresence(By locator);
	ZohoPage validateElementNotPresence(By locator);
	boolean isElementPresent(By locator);
}
