package com.generic.code;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.page.object.model.AgentInfoPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.ScreenShot;

public class AgentInfo {
	
	public static void getAgentInfo(WebDriver driver) throws Throwable {
				
		AgentInfoPage agentpf  = new AgentInfoPage(driver);		
		
		//Agent logo and contact information
		new ExplicitWait().getExplicitWaitVisible(driver, agentpf.getPropertyLogo());
		if(agentpf.getPropertyLogo().isDisplayed()) {
			System.out.println("Logagentinfopfo is present");
		} else {
			System.out.println("Logo is not present");
		}
		
		System.out.println("Agent Name is: "+agentpf.getAgentName().getText());
		System.out.println("Agent Phone#: "+agentpf.getAgentPhoneNum().getText());
		ScreenShot.getScreenShot(driver, "Agent Info");
		
		//Sign out
		Actions signOut = new Actions(driver);
		signOut.moveToElement(agentpf.getMyZooplaBtn()).build().perform();
		Highlighter.getcolor(driver,agentpf.getMyZooplaBtn(),"green");
		signOut.moveToElement(agentpf.getSignOutBtn()).build().perform();
		Highlighter.getcolor(driver, agentpf.getSignOutBtn(), "orange");
		ScreenShot.getScreenShot(driver, "Sign Out");
		agentpf.getSignOutBtn().click();		

	}

}
