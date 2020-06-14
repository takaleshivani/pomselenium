package com.zoho.listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.zoho.base.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoEventListener extends AbstractWebDriverEventListener{

	
	public void beforeFindBy(By locator,WebElement element,WebDriver driver)
	{
		/*System.out.println("Before Finding---" +by);
		System.out.println("Before Finding---" +element);
		System.out.println("Before Finding---" +driver);*/
		if(getSession().isExecuteListener()) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
			try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}catch(Exception e) {
				getDriver().fail("Element Not Found" + locator);
				getDriver().assertAll();
			}
		}
	}
	
	public WebConnector getDriver() {
		return getSession().getConn();//webconnector object
	}
	public void log(String message) {
		getSession().log(message);
	}
	public ZohoTestSession getSession()
	{
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
}
