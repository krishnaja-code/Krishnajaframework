package com.orangehrm.runnerscripts;

import org.testng.Assert;

import com.orangehrm.genericscripts.basic;

public class Admin extends basic
{
@org.testng.annotations.Test
public void DashbaordDisplayed()
{
	String expectedmsg="Dashboard";
	lp.clickLogin();
	if(hp.Dasboard().isDisplayed())
	{
		System.out.println("Dashboard is displayed");
	}
	String actualmsg=hp.Dasboard().getText();
	Assert.assertEquals(actualmsg, expectedmsg);
}
@org.testng.annotations.Test
public void Addcomponent()
{
	hp.PIM_button().click();
	hp.AddEmp_button().click();
	Assert.assertTrue(hp.FNTf().isDisplayed());
	Assert.assertTrue(hp.LNTf().isDisplayed());
	Assert.assertTrue(hp.MNTf().isDisplayed());
	Assert.assertTrue(hp.save().isDisplayed());
	System.out.println("Verification Successful");
}
@org.testng.annotations.Test
public void empiscreated()
{
	hp.PIM_button().click();
	hp.AddEmp_button().click();
	hp.FNTf().sendKeys("FirstName");
	hp.MNTf().sendKeys("MiddleName");
	hp.LNTf().sendKeys("Lastname");
	hp.save().click();
}
}
