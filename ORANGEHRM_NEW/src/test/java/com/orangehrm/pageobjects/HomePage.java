package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="(//span[.='PIM'])")
	private WebElement PIM_button;
	@FindBy(xpath="//a[.='Add Employee']")
	private WebElement AddEmp_button;
	@FindBy(xpath="//h6[.='Add Employee']")
	private WebElement AddEmp_Msg;
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement FNTf;
	@FindBy(name="middleName")
	private WebElement MNTf;	
	@FindBy(name="lastName")
	private WebElement LNTf;	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save;
	@FindBy(xpath="//h6[.='Dashboard']")
	private WebElement DashboardText;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}	
	public WebElement PIM_button()
	{
		return PIM_button;
	}
	public WebElement AddEmp_button()
	{
		return AddEmp_button;
	}
	public WebElement AddEmp_Msg()
	{
		return AddEmp_Msg;
	}	
	public WebElement FNTf()
	{
		return FNTf;
	}	
	public WebElement MNTf()
	{
		return MNTf;
	}	
	public WebElement LNTf()
	{
		return LNTf;
	}	
	public WebElement save()
	{
		return save;
	}
	public WebElement Dasboard() 
	{
		return DashboardText;
		
	}
}
