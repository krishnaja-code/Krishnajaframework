package com.orangehrm.genericscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.pageobjects.HomePage;
import com.orangehrm.pageobjects.LoginPage;
import com.orangehrm.pageobjects.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {	
	ReadProperties rp;
	LoginPage lp;
	WebDriver driver;
	public HomePage hp;
	LogoutPage lo;
	
	@Parameters("BrowserInit")
	@BeforeClass
	public void browserInitialization(String BrowserInit) 
	{
		switch(BrowserInit)
		{
		case "chrome": WebDriverManager.chromedriver().setup();
		break;
		
		case "fire": WebDriverManager.firefoxdriver().setup();
		break;
		
		case "edge": WebDriverManager.edgedriver().setup();
		break;
		
		default: System.out.println("Invalid Initialization");
		break;	
		}
	}	
	@Parameters("Browsers")
	@BeforeMethod
	public void browserSetUp(String Browsers) throws Exception  
	{
		switch(Browsers)
		{
		case "chrome": driver= new ChromeDriver();
		break;
		
		case "fire": driver= new FirefoxDriver();
		break;
		
		case "edge": driver= new EdgeDriver();
		break;
		
		default: System.out.println("Invalid Browser");
		}
		rp= new ReadProperties();
		driver.manage().timeouts().implicitlyWait(rp.waitTime,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(rp.readUrl());
		hp= new HomePage(driver);
		lp= new LoginPage(driver);
		lo= new LogoutPage(driver);
		lp.enterUsn().sendKeys(rp.readUsn());
		lp.enterPsw().sendKeys(rp.readPsw());
		lp.clickLogin().click();	
	}
	@Test
	public void test() 
	{
		System.out.println("Hello");
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception 
	{
		if(result.FAILURE== result.getStatus())
		{
			CaptureDefects.getDefects(driver,result);
		}
		Thread.sleep(3000);
		lo.logoutDropdown().click();
		lo.logoutOption().click();
		//driver.quit();
	}
	@AfterClass
	public void reports()
	{
		
	}
}

