package com.orangehrm.genericscripts;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class CaptureDefects implements ApplicationConstants 
{
	public static void getDefects(WebDriver driver, ITestResult result) throws Exception
	{
		Date d= new Date();
		String d1= d.toString().replace(":","-");
		TakesScreenshot ts= (TakesScreenshot)driver;
		File temp= ts.getScreenshotAs(OutputType.FILE);
		File perm= new File(DefectsPath+d1+result.getName()+".png");
		FileHandler.copy(temp, perm);
	}
}