package com.goibibo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.goibibo.base.BaseClass;

public class LandingPage extends BaseClass {
	// locators 
	// hotels link
	@FindBy(xpath = "//span[contains(text(),'Hotels')]")
	private WebElement hotelsLink;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void clickOnHotes() {
		hotelsLink.click();
	}

}
