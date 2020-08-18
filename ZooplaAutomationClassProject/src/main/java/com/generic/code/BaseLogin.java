package com.generic.code;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.ScreenShot;

public class BaseLogin {

	public static WebDriver getLogin() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		LoginPage login = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.get(BaseConfig.getConfig("URL"));
		ScreenShot.emptyScreenShotFolder();

		login.getAcceptCookie().click();

		Highlighter.getcolor(driver, login.getSignInBtn());
		ScreenShot.getScreenShot(driver, "SignInPage");

		login.getSignInBtn().click();

		new ExplicitWait().getExplicitWait(driver, login.getEmail());

		login.getEmail().sendKeys(BaseConfig.getConfig("userName"));
		Highlighter.getcolor(driver, login.getEmail(), "red");

		login.getPassWord().sendKeys(BaseConfig.getConfig("passWord"));
		Highlighter.getcolor(driver, login.getPassWord(), "orange");

		Highlighter.getcolor(driver, login.getSubmitBtn(), "yellow");
		ScreenShot.getScreenShot(driver, "Login Page");
		login.getSubmitBtn().click();
		System.out.println("Title of the Page is: " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Home Page");
		return driver;

	}

}
