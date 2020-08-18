package com.cucumber.code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.page.object.model.AgentInfoPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.ScreenShot;

public class AgentInfo {
	
	private WebDriver driver;
	private AgentInfoPage agentpf;
	
	public AgentInfo(WebDriver driver) {
		this.driver=driver;
		agentpf  = new AgentInfoPage(driver);	
	}
	
	public void checkAgentLogo() {
		new ExplicitWait().getExplicitWaitVisible(driver, agentpf.getPropertyLogo());
		if(agentpf.getPropertyLogo().isDisplayed()) {
			System.out.println("Logagentinfopfo is present");
		
		} else {
			System.out.println("Logo is not present");
		}
		
	}
	public void displayAgentInfo() throws Throwable {
		
		System.out.println("Agent Name is: "+agentpf.getAgentName().getText());
		System.out.println("Agent Phone#: "+agentpf.getAgentPhoneNum().getText());
		ScreenShot.getScreenShot(driver, "Agent Info");
		
	}
	public void logOut() throws Throwable {
		
		Actions signOut = new Actions(driver);
		signOut.moveToElement(agentpf.getMyZooplaBtn()).build().perform();
		Highlighter.getcolor(driver,agentpf.getMyZooplaBtn(),"red");
		signOut.moveToElement(agentpf.getSignOutBtn()).build().perform();
		Highlighter.getcolor(driver, agentpf.getSignOutBtn(), "yellow");
		ScreenShot.getScreenShot(driver, "Sign Out");
		agentpf.getSignOutBtn().click();		

	}

}
