package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="username")
	private WebElement usnTf;
	
	@FindBy(name="password")
	private WebElement pswTf;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);//In maven to initialize the elements we use pagefactory
	}
	public WebElement enterUsn()
	{
		return usnTf;
	}
	public WebElement enterPsw()
	{
		return pswTf;
	}
	public WebElement clickLogin()
	{
		return loginBtn;
	}
}