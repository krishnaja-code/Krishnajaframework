package com.orangehrm.genericscripts;


import java.sql.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listnerclass implements ITestListener
{
	
ExtentSparkReporter reporter;
ExtentReports report;
public void onstart(ITestContext context)
{
	System.out.println("Before Execution");
}
public void onsTesttart(ITestResult result)
{

Date d=new Date(0);
String d1=d.toString().replace(":", ".");
	System.out.println("Test Execution is started");
	reporter = new ExtentSparkReporter("./Testextentreport/"+d1+" .html");
	reporter.config().setDocumentTitle("Hybridframework");
	reporter.config().setReportName("orangehrm");
	reporter.config().setTheme(Theme.DARK);
	report=new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("Testername","Admin");
	report.setSystemInfo("os","windows");
	report.setSystemInfo("env","windows 11");
	report.setSystemInfo("build is","1234");
}
public void onsTestsuccess(ITestResult result)
{
	System.out.println("Testcase Execution is success");
	ExtentTest test=report.createTest(result.getName());
	System.out.println(test.getStatus().PASS);
	test.log(Status.PASS,result.getName()+"Is success");
}
}