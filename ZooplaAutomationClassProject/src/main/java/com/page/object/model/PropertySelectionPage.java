package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertySelectionPage {
	
	public PropertySelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='search-input-location']")
	private WebElement locationName;
	@FindBy(xpath="//button[@id='search-submit']")
	private WebElement searchSubmit;
	@FindBy(xpath="//a[@class='listing-results-price text-price']")
	private List<WebElement> homePrices;
	
	
	public WebElement getLocationName() {
		return locationName;
	}
	public WebElement getSearchSubmit() {
		return searchSubmit;
	}
	public List<WebElement> getHomePrices() {
		return homePrices;
	}

}
