package com.orangehrm.genericscripts;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties implements ApplicationConstants 
{
	public Properties pro;	
	public ReadProperties() throws Exception
	{
        pro = new Properties();		
		FileInputStream fis = new FileInputStream(propertiespath);		
		pro.load(fis);
	}	
	public String readUrl()
	{
	String readUrl = pro.getProperty("TestUrl");
	  return readUrl;	  
	}	
	public String readUsn()
	{
	String readUsn = pro.getProperty("TestUsn");
	  return readUsn;	  
	}	
	public String readPsw()
	{
	String readPsw = pro.getProperty("TestPsw");
	  return readPsw;	  
	}
}

