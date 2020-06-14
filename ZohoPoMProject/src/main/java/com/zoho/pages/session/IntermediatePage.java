package com.zoho.pages.session;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBase;
import com.zoho.base.pages.ZohoPage;


public class IntermediatePage extends ZohoBaseSessionPage{
	/*@FindBys({
		@FindBy(id="zl-myapps"),
		@FindBy(tagName="a")
	})*/
	public List<WebElement> pageOptions;
	
	@FindBy(xpath=Constants.CRM_LINK)
	public WebElement crmLink;
	
	public ZohoPage validateIntermediatePageOptions()
	{
		System.out.println("------validating Intermediate Options--------");
		waitForPageToLoad();
		try {
			pageOptions=getCurrentDriver().findElements(By.xpath("//*[@id='zl-myapps']//a"));
		System.out.println(pageOptions.size());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<String>intermediate=Arrays.asList(Constants.intermediatePageOptions);
		for(WebElement e : pageOptions)
		{
			System.out.println(e.getText()+"----------"+intermediate.contains(e.getText()));
			/*if(!intermediate.contains(e.getText()))
				validator(false).fail("Option Not Found---"+e.getText());*/
		}
		return this;
	}
	
	public ZohoPage gotoDefaultLandingPage()
	{
		crmLink.click();
		return new DefaultLandingPage();
	}
	
}
