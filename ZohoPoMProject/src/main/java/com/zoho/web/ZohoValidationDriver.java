package com.zoho.web;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.base.session.ZohoTestSession;

public abstract class ZohoValidationDriver implements WebConnector  {
	EventFiringWebDriver driver;
	boolean stopExecution;
	SoftAssert softAssert=new SoftAssert();
	
	public ZohoPage validateText(String locator,String expectedText) {
		// TODO Auto-generated method stub
		System.out.println("------Validating Text------------");
		/*System.out.println("staus is ---"+isStopExecution());
		assertEquals(actualText, expectedText);*/
		String actualText="Shivani";
		if(!expectedText.equals(actualText))
		{
			fail("Text does not match");
		}
		getSession().takeScreenshot();
		return getSession().getCurrentPage();
	}
	
	
	public boolean isStopExecution() {
		return stopExecution;
	}


	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}


	public ZohoPage validateTitle(String ExpectedTitle) {
		System.out.println("------Validating Title------------");
		/*System.out.println("staus is ---"+isStopExecution());
		Assert.assertEquals(driver.getTitle(), ExpectedTitle);*/
		log(ExpectedTitle);
		if(!ExpectedTitle.equals(driver.getTitle()))
		{
			softAssert.fail("Title do not match");
			if(isStopExecution())
			assertAll();
		}
	
		return getSession().getCurrentPage();
		
	}

	public ZohoPage validateLogin() {
		// TODO Auto-generated method stub
		return getSession().getCurrentPage();
	}
	
	public ZohoPage Display() {
		System.out.println("--------Displaying-----------");
		return getSession().getCurrentPage();
	}
	
	public ZohoTestSession getSession() {
		// TODO Auto-generated method stub
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public void assertAll() {
		// TODO Auto-generated method stub
		softAssert.assertAll();
	}
	
	public ZohoPage validateElementPresence(By locator) {
		//validations
		if(!isElementPresent(locator))
			fail("Element Not Found"+locator);
		
		return getSession().getCurrentPage();
	}
	
	public ZohoPage validateElementNotPresence(By locator) {
		//validations
		if(isElementPresent(locator))
			fail("Element Not Found"+locator);
		return getSession().getCurrentPage();
	}

	public SoftAssert getSoftAssert() {
		return softAssert;
	}


	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}
	
	public void log(String message)
	{
		getSession().log(message);
	}
	public void fail(String message)
	{
		//fail in report
		getSession().takeScreenshot();
		getSession().failTest(message);
		
		softAssert.fail(message);
		if(isStopExecution())
		assertAll();
	}
	
	public boolean isElementPresent(By locator)
	{
		getSession().setExecuteListener(false);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			getSession().setExecuteListener(true);
			return false;
		}
		getSession().setExecuteListener(true);
		return true;
	}
}
