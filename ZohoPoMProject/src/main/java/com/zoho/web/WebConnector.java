package com.zoho.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.zoho.base.session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector{
	void opneBrowser(String browsername);
	void navigate(String URl);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	
	ZohoTestSession getSession();
	boolean isStopExecution();
	void setStopExecution(boolean stopExecution);
	void assertAll();
	SoftAssert getSoftAssert();
	void setSoftAssert(SoftAssert softAssert);
	void log(String message);
	void fail(String message);
}
