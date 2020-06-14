package com.zoho.base.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;
import com.zoho.base.session.ZohoTestSession;
import com.zoho.pages.components.common.session.Header;
import com.zoho.pages.session.DefaultLandingPage;
import com.zoho.pages.session.lead.LeadDetailsPage;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.util.DataUtil;
import com.zoho.web.WebConnector;

public class ZohoBase implements ZohoPage{

	public ZohoBase()
	{
		System.out.println("-----------ZohoBase Constructor-----------------");
		PageFactory.initElements(getCurrentDriver(), this);
		getSession().setCurrentPage(this);
		//getSession().takeScreenshot();
	}
	public ZohoPage gotoHomePage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void gotoRegisterPage() {
		// TODO Auto-generated method stub
		
	}

	public ZohoPage submitUsername(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createDeal() {
		// TODO Auto-generated method stub
		
	}

	public void logOut() {
		// TODO Auto-generated method stub
		
	}

	public ZohoPage openBrowser(String browser) {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub
		
	}
	public ZohoPage gotoEnterUsernamePage()
	{
		return null;
	}
	public ZohoTestSession getSession()
	{
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public WebConnector getDriver() {
		return getSession().getConn();//webconnector object
	}
	
	public EventFiringWebDriver getCurrentDriver()
	{
		return getSession().getConn().getCurrentDriver();
	}
	public WebConnector validator(boolean stopExecution) {
		// TODO Auto-generated method stub
		System.out.println("------------Validation-------");
		getSession().getConn().setStopExecution(stopExecution);
		return getSession().getConn();
	}
	public void log(String message)
	{
		getSession().log(message);
	}
	public ZohoPage submitPassword(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
		int i=0;
		
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		if(state.equals("complete"))
			break;
		else
			wait(4);

		i++;
		}
		// check for jquery status
		i=0;
		while(i!=10){
	
			Long d= (Long) js.executeScript("return jQuery.active;");
			
			if(d.longValue() == 0 )
			 	break;
			else
				 wait(4);
			 i++;
				
			}
		
		}
	
	public void wait(int time)
	{
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException e)
		{
			
		}
	}

	public ZohoPage validateIntermediatePageOptions() {
		// TODO Auto-generated method stub
		System.out.println("---In Base------------");
		return null;
	}
	
	public ZohoPage gotoDefaultLandingPage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Header getHeader() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LeadDetailsPage submitDetails(String comapnyName, String lName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LeadsPage gottoLeadPage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ZohoPage deleteLead(String leadName,String leadCompany) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
