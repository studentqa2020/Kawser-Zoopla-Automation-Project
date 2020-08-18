package com.cucumber.code;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.ScreenShot;

public class BaseLogin {	
	
	private WebDriver driver;
	private LoginPage login;
	public BaseLogin(WebDriver driver) {
		this.driver=driver;
		login = new LoginPage(driver);
	}
	
	public void openUrl() throws Throwable {
		ScreenShot.emptyScreenShotFolder();
		driver.get(BaseConfig.getConfig("URL"));
	}
	
	public void clickSignIn() throws Throwable {
		login.getAcceptCookie().click();		
		Highlighter.getcolor(driver, login.getSignInBtn());				
		ScreenShot.getScreenShot(driver, "SignInPage");
		login.getSignInBtn().click();		
	}
	
	public void getLogin() throws Throwable {	
	
		new ExplicitWait().getExplicitWait(driver, login.getEmail());
		
		login.getEmail().sendKeys(BaseConfig.getConfig("userName"));
		Highlighter.getcolor(driver, login.getEmail(),"green");
				
		login.getPassWord().sendKeys(BaseConfig.getConfig("passWord"));
		Highlighter.getcolor(driver, login.getPassWord(),"yellow");		
				
		Highlighter.getcolor(driver, login.getSubmitBtn());		
		ScreenShot.getScreenShot(driver, "Login Page");
		login.getSubmitBtn().click();
		System.out.println("Title of the Page is: "+driver.getTitle());
		ScreenShot.getScreenShot(driver, "Home Page");			
	}

}
