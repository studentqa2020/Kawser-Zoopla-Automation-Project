package com.generic.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertySelectionPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.ScreenShot;

public class PropertySelection {
	public static void selectProperty(WebDriver driver) throws Throwable {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertySelectionPage propertypf = new PropertySelectionPage(driver);

		new ExplicitWait().getExplicitWait(driver, propertypf.getLocationName());
		propertypf.getLocationName().sendKeys(BaseConfig.getConfig("SearchLocationName"));

		Highlighter.getcolor(driver, propertypf.getLocationName(), "blue");
		Highlighter.getcolor(driver, propertypf.getSearchSubmit(), "green");
		ScreenShot.getScreenShot(driver, "Search City");
		propertypf.getSearchSubmit().click();

		String[] price;
		List<Integer> intPrice = new ArrayList<>();
		for (int i = 0; i < propertypf.getHomePrices().size(); i++) {
			price = propertypf.getHomePrices().get(i).getText().split(" ");
			intPrice.add(Integer.parseInt(price[0].replace("£", "").replace(",", "").trim()));
		}
		System.out.println("House Prices: " + intPrice);
		Collections.sort(intPrice);
		System.out.println("House Prices Sorted Asc: " + intPrice);
		Collections.reverse(intPrice);
		System.out.println("House Prices Sorted Desc: " + intPrice);

		// select 5th property

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertypf.getHomePrices().get(4));

	}
}
