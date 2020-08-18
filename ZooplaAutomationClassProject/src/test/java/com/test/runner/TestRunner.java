package com.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"features/zoopla.feature"},
		glue = {"com.step.def"},
		plugin = { "pretty", 
				"html:target/site/cucumber-pretty", 
				"rerun:target/rerun.txt",
				"json:target/cucumber.json" },
		
	//	plugin = {"pretty", "html:target" , 
	//			"json:target/cucumber.json" , 
	//			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		monochrome = true		
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	

}
