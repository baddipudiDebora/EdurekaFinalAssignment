package com.goibibo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.base.BaseClass;

public class SingleHotelsViewPage extends BaseClass {
	// checkInDatebutton
	@FindBy(xpath = "(//button[contains(text(),'Select')])[1]")
	private WebElement selectRoom;

	// constructor
	public SingleHotelsViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectRoom() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		selectRoom.click();
	}

}
