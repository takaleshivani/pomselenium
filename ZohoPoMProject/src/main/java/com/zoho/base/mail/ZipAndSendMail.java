package com.zoho.base.mail;

 


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

 

public class ZipAndSendMail
{
	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
	static String[] toEmails = { "takaleshivani10@rediff.com" };
	static String fromUser = "shivanitakale10";//just the id alone without @gmail.com
	static String password = "Fast@1104";

	
    public static void main(String[] args) throws Exception
    {
    	//fire this command ->mvn exec:java -Dexec.mainClass="com.zoho.mail.ZipAndSendMail"
		//report folder - extent reports
    	Properties prop = new Properties();
    	//FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//prop.properties");
    	//prop.load(fs);
		//String reportFolder=prop.getProperty("reportPath");
    	String reportFolder="C:\\Users\\Asus\\eclipse-workspace\\ZohoPoMProject\\reports";
    	// find latest folder

                File dir = new File(reportFolder);
        	    File[] files = dir.listFiles();
        	    File lastModified = Arrays.stream(files).filter(File::isDirectory).max(Comparator.comparing(File::lastModified)).orElse(null);
        	    System.out.println(lastModified.getName());
        	    
        	//zip
                Zip.zipDir(reportFolder+"\\"+lastModified.getName(), reportFolder+"\\"+lastModified.getName()+".zip");
                
            //mail
                Mail javaEmail = new Mail();

        		javaEmail.setMailServerProperties();
        		

        		javaEmail.createEmailMessage(
        				"Automation Test Reports", // subject
        				"Please find the reports in attachment.", // body
        				reportFolder+"\\"+lastModified.getName()+".zip", // attachment path
        				"Reports.zip", // name of attachment
        				toEmails// receivers
        				);
        		javaEmail.sendEmail(fromUser,password);
        		
        		
      }
    



 
 

}