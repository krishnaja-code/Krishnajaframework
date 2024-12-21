package com.orangehrm.genericscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class basic 
{
@BeforeClass
public void BrowserInitialization()
{
	
}
WebDriver driver;
public LoginPage lp;
LogoutPage lo;
public HomePage hp;
@Parameters("Browsers")
@BeforeMethod
public void Browsersetup(String BrowserName)
{
	switch(BrowserName)
	{
	case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
    case "fire":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
    case "edge":
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;
    default:
        throw new IllegalArgumentException("Invalid Browser" );
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	lp= new LoginPage(driver);
	lp.enterUsn().sendKeys("Admin");
	lp.enterPsw().sendKeys("admin123");
	lp.clickLogin().click();
	lo= new LogoutPage(driver);
	lo.logoutDropdown().click();
	lo.logoutOption().click();
	hp= new HomePage(driver);
	
	}

@Test
public void Test()
{
	System.out.println("Test working");
}
@AfterMethod
public void After()
{
	System.out.println("After working");
}
@AfterClass
public void Afterclass()
{
	System.out.println("Afterclass working");
}
}
