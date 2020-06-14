package com.zoho.base.pages;

import org.openqa.selenium.By;

public class Constants {
	
	public static final String GRID_RUN="N";
	
	public static final String Login_Link="a.zh-login";
	
	public static final String LOGIN_ID="//*[@id='login_id']";
	public static final By LOGIN_ID_Locator=By.xpath(LOGIN_ID);
	
	public static final String Next_Button="//*[@id='nextbtn']/span";
	
	public static final String Password_XPATH="//*[@id='password']";
	public static final By Password_Locator=By.xpath(Password_XPATH);
	
	public static final String HOME_PAGE_TITLE="Zoho - Cloud Software Suite and SaaS Applications for Businesses";
	
	public static final String DIV_FOURTH_COL="#zl-myapps > div.ea-app-container";
	public static final By DIV_FOURTH__COL_Locator=By.cssSelector(DIV_FOURTH_COL);
	
	public static final String CRM_LINK="//div[text()='CRM']";
	public static final By CRM_LINK_Locator=By.xpath(CRM_LINK);
	
	public static final String ADD_ICON="//*[@id='createIcon']";
	public static final By ADD_ICON_Locator=By.xpath(ADD_ICON);
	
	public static final String SUB_LEAD_HEADER="//*[@id='submenu_Leads']";
	public static final By LEAD_HEADER_Locator=By.xpath(SUB_LEAD_HEADER);	
		
	public static final String SUB_CONTACT_HEADER="//*[@id='submenu_Contacts']";
	public static final By CONTACT_HEADER_LOCATOR=By.xpath(SUB_CONTACT_HEADER);
	
	public static final String LEAD_HEADER="//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div/a";
	public static final String CONTACT_HEADER="//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[3]/a";
	
	public static final String LEAD_COMPANY="//*[@id='Crm_Leads_COMPANY']";
	public static final String LEAD_NAME="//*[@id='Crm_Leads_LASTNAME']";
	public static final String LEAD_SAVE_BUTTON="//*[@id='saveLeadsBtn']";
	public static final String BACK_DETAILS="//*[@id='backArrowDV']/span";
	
	public static final String[] intermediatePageOptions= {"Analytics","Assi","Books","Calender","Campaigns","Cliq","Connect","CRM","Desk","Invoice"};

	public static final String REPORT_PATH=System.getProperty("user.dir")+"//reports//";
}
