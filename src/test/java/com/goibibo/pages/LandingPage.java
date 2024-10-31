package com.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.goibibo.base.BaseClass;

public class LandingPage extends BaseClass {
	// 1. locators
	// hotels link
	@FindBy(xpath = "//span[@role='presentation']")
	private WebElement popup;

	@FindBy(xpath = "//span[contains(text(),'Hotels')]")
	private WebElement hotelsLink;

	// Bus link
	@FindBy(xpath = "(//span[contains(text(),'Bus')])[1]")
	private WebElement BusLink;

	// 2. Constructor
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. methods
	public  void  closePopUpWindow(){ popup.click();
		System.out.println("Pop Up Window closed");}
	public void clickOnHotes() {
		hotelsLink.click();
	}

	public void clickOnBus() {
		BusLink.click();
	}
}
