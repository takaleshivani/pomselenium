package com.zoho.suite.testcases.deletion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.zoho.base.normalpage.LaunchPage;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.base.session.ZohoTestSession;


public class SampleTest {
	static WebDriver driver;
	public static final String[] intermediatePageOptions= {"Analytics","Assi","Books","Calender","Campaigns","Cliq","Connect","CRM","Desk","Invoice"};
	public static void main(String args[]) throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.get("https://www.zoho.com/in/crm/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='block-block-3']/div/div/div[3]/div[3]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='login_id']")).sendKeys("shivanitakale10@gmail.com");
		driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Fast@1104");
		driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[2]/a")).click();
		Thread.sleep(2000);
		List<WebElement> element = driver.findElements(By.xpath("//*[@id='listViewTable']/div/div[2]/div[2]//lyte-yield[@class='lyteExpTableRowGroup']//lyte-exptable-tr"));
		List<WebElement> leadTobedeleted=driver.findElements(By.xpath("//*[@id='listViewTable']/div/div[2]/div[2]//lyte-yield[@class='lyteExpTableRowGroup']//lyte-exptable-tr//lyte-exptable-td[4]"));
		List<WebElement> checkbox=driver.findElements(By.xpath("//*[@id='listViewTable']/div/div[2]/div[2]//lyte-yield[@class='lyteExpTableRowGroup']//lyte-exptable-tr//lyte-exptable-td[2]"));
		List<WebElement> CompanyName=driver.findElements(By.xpath("//*[@id='listViewTable']/div/div[2]/div[2]//lyte-yield[@class='lyteExpTableRowGroup']//lyte-exptable-tr//lyte-exptable-td[5]"));
		 String Cliets = "Apurva Mandurnekar";
		    for(int i =0;i<leadTobedeleted.size();i++){
		        System.out.println("Lead Name is: " + leadTobedeleted.get(i).getText() + "corresponding lcompany Name is : " + CompanyName.get(i).getText());
		        // now on the basis of column value click the corresponding link
		        if(leadTobedeleted.get(i).getText().equals(Cliets)){
		        	checkbox.get(i).click();
		        	Thread.sleep(1000);
		        	driver.findElement(By.xpath("//*[@id='moreAct']")).click();
		        	driver.findElement(By.xpath("//*[@class='popoverWrapper moreActionPopup noFreeze']//div[@class='lytePopover']//lyte-yield[@yield-name='popover']//ul//li[3]"));
		        	if (isAlertPresent()) 
		        	{
		        	        driver.switchTo().alert();
		        	        driver.switchTo().alert().accept();
		        	        driver.switchTo().defaultContent();
		        	}
		        	else
		        	{
		        		driver.switchTo().frame(0);
		        		driver.findElement(By.xpath("//*[@id='deleteButton']"));
		        		driver.switchTo().defaultContent();
		        	}
		            break;
		        }
		    }
		
		/*for(WebElement e:element)
		{
		         String Value;
		         List<WebElement> Checkbox=driver.findElements(By.xpath("//*[@id='listViewTable']/div/div[2]/div[2]//lyte-yield[@class='lyteExpTableRowGroup']//lyte-exptable-tr//lyte-exptable-td[2]"));
				  for(int i=0;i<Checkbox.size();i++){
				    Value = Checkbox.get(i).getAttribute("customCheckBox");
				    if(Value.equalsIgnoreCase("Apurva Mandurnekar"));
				      Checkbox.get(i).click();
				  }
				System.out.println("Lead Name--------------"+e.getText());
				if(e.getText().equals("Apurva Mandurnekar"))
				{
					//driver.findElement(By.xpath("//*[@id='listViewTable']/div/div[2]/div[2]//lyte-yield[@class='lyteExpTableRowGroup']//lyte-exptable-tr//lyte-exptable-td[2]")).click();
					driver.findElement(By.xpath("(//span[@class='customCheckBox'])[24]")).click();
					driver.findElement(By.xpath("//*[@id='moreAct']")).click();
					driver.findElement(By.xpath("/html/body/lyte-wormhole[1]/lyte-yield/div/div/lyte-yield/lyte-popover-content/ul/li[3]")).click();
					driver.switchTo().alert().accept();
				}
		}*/
		
	}
	private static boolean isAlertPresent() {
		// TODO Auto-generated method stub
		try {
		     driver.switchTo().alert();
		     return  true;
		     } // try
		     catch (Exception e) 
		     {
		        return false;
		    }
	}
}
