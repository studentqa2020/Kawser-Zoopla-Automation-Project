package com.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	private WebElement acceptCookie;
	//@FindBy(xpath="//a[@class='button button--tertiary-dark account-link__text']")
	@FindBy(xpath="(//*[text()='Sign in'])[1]")
	private WebElement signInBtn;
	@FindBy(xpath="//input[@id='signin_email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='signin_password']")
	private WebElement passWord;
	@FindBy(xpath="//button[@id='signin_submit']")
	private WebElement submitBtn;
	public WebElement getAcceptCookie() {
		return acceptCookie;
	}
	public WebElement getSignInBtn() {
		return signInBtn;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassWord() {
		return passWord;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
		
}
