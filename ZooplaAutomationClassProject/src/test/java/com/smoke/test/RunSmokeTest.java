package com.smoke.test;

import org.openqa.selenium.WebDriver;

import com.generic.code.AgentInfo;
import com.generic.code.BaseLogin;
import com.generic.code.PropertySelection;

public class RunSmokeTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = BaseLogin.getLogin();
		PropertySelection.selectProperty(driver);
		AgentInfo.getAgentInfo(driver);		
		driver.quit();

	}

}
