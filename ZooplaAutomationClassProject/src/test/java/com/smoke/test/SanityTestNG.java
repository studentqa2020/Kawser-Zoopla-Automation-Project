package com.smoke.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.generic.code.AgentInfo;
import com.generic.code.BaseLogin;
import com.generic.code.PropertySelection;
import com.report.ExtentTestManager;

public class SanityTestNG {

	WebDriver driver;
	ExtentTest test;
	
	@BeforeTest
	public void setup() throws Throwable {
		test = ExtentTestManager.startTest("Regression_tc1"); 
		test.assignCategory("Regression Test");
		test.createNode("setup");
		driver = BaseLogin.getLogin();
	}
	
	@Test
	public void getProperty() throws Throwable {
		PropertySelection.selectProperty(driver);
	}
	
	@Test(dependsOnMethods="getProperty")
	public void getAgent() throws Throwable {
		AgentInfo.getAgentInfo(driver);
	}
	@AfterTest
	public void tearOff() {
		driver.quit();
		ExtentTestManager.endTest();
	}
	
}
