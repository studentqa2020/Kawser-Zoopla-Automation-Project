package com.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentInfoPage {
	
	public AgentInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@class='js-lazy-loaded']")
	private WebElement propertyLogo;
	@FindBy(xpath="(//h4[@class='ui-agent__name'])[1]")
	private WebElement agentName;
	@FindBy(xpath="(//*[@class='ui-link'])[4]")
	private WebElement agentPhoneNum;
	//@FindBy(xpath="//*[@id='header-account-panel__signed-in-link']")
	@FindBy(xpath="//*[@class='css-1mjljx5 eson0er0']//*[text()='My Zoopla']")
	private WebElement myZooplaBtn;
	//@FindBy(xpath="//span[contains(text(),'Sign out')]")
	@FindBy(xpath="(//div[@content='Sign out'])[1]")
	private WebElement signOutBtn;
	
	public WebElement getPropertyLogo() {
		return propertyLogo;
	}
	public WebElement getAgentName() {
		return agentName;
	}
	public WebElement getAgentPhoneNum() {
		return agentPhoneNum;
	}
	public WebElement getMyZooplaBtn() {
		return myZooplaBtn;
	}
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}


}
