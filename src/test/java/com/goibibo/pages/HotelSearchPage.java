package com.goibibo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.goibibo.base.BaseClass;

public class HotelSearchPage {
	// HotelSearchtextbox
	@FindBy(id = "downshift-1-input")
	private WebElement hotelSearchtextbox;
	// checkInDatebutton
	@FindBy(xpath = "//div[contains(text(),'Check-in')]")
	private WebElement checkInDatebutton;
	// checkInDatetoEnter
	@FindBy(xpath = "// span[contains(text(),'25')]")
	private WebElement checkInDatetoEnter;
	// checkOutDatebutton
	@FindBy(xpath = "//div[contains(text(),'Check-out')]")
	private WebElement checkOutDatebutton;
	// checkOutDatetoEnter
	@FindBy(xpath = "// span[contains(text(),'29')]")
	private WebElement checkOutDatetoEnter;
	// numberofGuestButton
	@FindBy(xpath = "//input[@value='2 Guests in 1 Room ']")
	private WebElement numberofGuestButton;
	// minusnumberofGuestButton
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/span[1]")
	private WebElement minusnumberofGuestButton;
	// doneButtonNumGuest
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	private WebElement doneButtonNumGuest;

	// search button
	@FindBy(xpath = "//button[contains(text(),'Search Hotels')]")
	private WebElement searchbutton;

	// constructor
	public HotelSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterHotels(String Hotels) throws InterruptedException {
		hotelSearchtextbox.sendKeys(Hotels);
		Thread.sleep(2000);
		hotelSearchtextbox.sendKeys(Keys.ARROW_DOWN);
		hotelSearchtextbox.sendKeys(Keys.ENTER);
	}

	public void enterCheckInDate() throws InterruptedException {
		checkInDatebutton.click();
		checkInDatetoEnter.click();
		Thread.sleep(2000);
	}

	public void enterCheckOutDate() throws InterruptedException {
		
		checkOutDatebutton.click();
		Thread.sleep(3000);
		checkOutDatetoEnter.click();
	}

	public void enterNumofGuest() throws InterruptedException {
		numberofGuestButton.click();
		minusnumberofGuestButton.click();
		doneButtonNumGuest.click();

	}

	public void clickOnSearch() {
		searchbutton.click();
	}
}
