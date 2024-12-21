package com.orangehrm.genericscripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class basepage_one {
    WebDriver driver;
    ReadProperties rp;
    LoginPage lp;
    LogoutPage lo;
    HomePage hp;

    @Parameters("Browser")
    @BeforeClass
    public void BrowserInitialization(String Browser) throws Exception {
        rp = new ReadProperties();
        switch (Browser) {
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
                throw new IllegalArgumentException("Invalid Browser: " + Browser);
        }
        driver.manage().timeouts().implicitlyWait(rp.waitTime,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void BrowserSetup() throws Exception {
        rp = new ReadProperties();
        driver.get(rp.readUrl());
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        lo = new LogoutPage(driver);
        lp.enterUsn().sendKeys(rp.readUsn());
        lp.enterPsw().sendKeys(rp.readPsw());
        lp.clickLogin().click();
    }

    @Test
    public void Test() {
      //  Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed: Dashboard not loaded.");
		System.out.println("Hello");
    }

    @AfterMethod
    public void TearDown() throws Exception {
        Thread.sleep(3000);
        lo.logoutDropdown().click();
        lo.logoutOption().click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
