package com.step.def;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.cucumber.code.AgentInfo;
import com.cucumber.code.BaseLogin;
import com.cucumber.code.PropertySelection;
import com.cucumber.code.SetupBrowser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver driver;
	private BaseLogin login;
	private PropertySelection ps;
	private AgentInfo agentinfo;	
		
	@Given("User is on Zoopla Webpage")
	public void user_is_on_Zoopla_Webpage() throws Throwable {	
		driver = SetupBrowser.setup(driver);
		
		login=new  BaseLogin(driver);		
		login.openUrl();
		assertEquals(driver.getTitle(),"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");		
	}

	@When("User click on Signin Buton")
	public void user_click_on_Signin_Buton() throws Throwable {
		login.clickSignIn();	
		assertEquals(driver.getTitle().substring(0, 29),"Register or sign in to Zoopla");			    
	}

	@When("User Enters Credentials and Submit Login")
	public void user_Enters_username_and_Password_and_Submit_Login() throws Throwable {
		login.getLogin();   
	}	

	@Then("User logged in")
	public void user_logged_in() {
		assertEquals(driver.getTitle(),"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	}

	@Given("User is on Search Property page")		
	public void user_is_on_Search_Property_page() {
		ps = new PropertySelection(driver);
		assertEquals(driver.getTitle(),"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	}

	@When("User Enters City Name and Search Properties")
	public void user_Enters_City_Name_and_Search_Properties() throws Throwable {		
	    ps.searchProperty();
	}	

	@Then("User gets the Properties page")
	public void user_gets_the_Properties_page() {
	    assertEquals(driver.getTitle(),"Property for Sale in New York - Buy Properties in New York - Zoopla");
	}

	@When("User Display all Properties prices in desc order")
	public void user_Display_all_Properties_prices_in_desc_order() {
	   ps.displayPropertyPrices();
	}

	@When("User Selects Fifth Property")
	public void user_Selects_Fifth_Property() {
	    ps.selectProperty();
	}
	
	@When("User Verify Logo")
	public void user_Verify_Logo() {
		agentinfo = new AgentInfo(driver);
	    agentinfo.checkAgentLogo();
	}

	@When("User Display Agent name and Phone Num")
	public void user_Display_Agent_name_and_Phone_Num() throws Throwable {
	    agentinfo.displayAgentInfo();
	}

	@When("User clicks on Sign out button")
	public void user_clicks_on_Sign_out_button() throws Throwable {
	    agentinfo.logOut();
	}

	@Then("User Signs Out")
	public void user_Signs_Out() {
	    driver.quit();
	}


}
