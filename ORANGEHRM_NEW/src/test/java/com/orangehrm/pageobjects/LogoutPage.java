package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(xpath="(//img[@alt='profile picture'])[1]")
	private WebElement logoutDropdown;
	
	@FindBy(xpath="(//a[text()='Logout'])")
	private WebElement logoutOption;
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement logoutDropdown()
	{
		return logoutDropdown;
	}
	
	public WebElement logoutOption()
	{
		return logoutOption;
	}
}
