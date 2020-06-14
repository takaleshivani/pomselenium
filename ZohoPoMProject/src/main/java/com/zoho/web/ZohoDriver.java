package com.zoho.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.base.session.ZohoTestSession;
import com.zoho.listener.ZohoEventListener;

public class ZohoDriver extends ZohoValidationDriver {
	//EventFiringWebDriver driver;
	
	public void opneBrowser(String browsername) {
		// TODO Auto-generated method stub
		
		log("Opening Browser");
		System.setProperty(SystemProperty.BROWSER_LOGFILE,"NULL");
		if(Constants.GRID_RUN.equals("Y"))
		{
			//desiredCapabilities
			DesiredCapabilities cap=new DesiredCapabilities();
			if(browsername.equalsIgnoreCase("firefox"))
			{
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
			}
			else if(browsername.equalsIgnoreCase("ie"))
			{
				cap.setBrowserName("ie");
				cap.setPlatform(Platform.WINDOWS);
			}
			try {
			driver=new EventFiringWebDriver(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
				log("unable to launch"+e.getMessage());
				setStopExecution(true);
				fail("Unable to Launch"+e.getMessage());
			}
			
			
		}else {
				driver=new EventFiringWebDriver(new FirefoxDriver());
				driver.register(new ZohoEventListener());
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.manage().window().maximize();
			
		}
	}

	public void navigate(String URl) {
		// TODO Auto-generated method stub
		log("Navigating to URL" +URl);
		driver.get(URl);
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void logout() {
		// TODO Auto-generated method stub
		//ZohoWebConnector conn=new ZohoDriver();
		
	}


	public ZohoPage validateLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	public EventFiringWebDriver getCurrentDriver()
	{
		return driver;
	}





	public ZohoPage validateText(String expectedText) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
