package com.goibibo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedtoPaymentPage {
	// enterFname
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter First Name']")
	private WebElement firstNamebox;

	// lastName
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter Last Name']")
	private WebElement lastNamebox;

	// email
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter Email Address']")
	private WebElement emailbox;

	// mobileNumber
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter Phone Number']")
	private WebElement mobileNumberbox;

	// proceedtopay
	@FindBy(xpath = "//button[contains(text(),'Proceed To Payment Options')]")
	private WebElement proceedtopay;

	// constructor
	public ProceedtoPaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterBookingDetails(String fname, String lname, String email, String mNumber)
			throws InterruptedException {
		firstNamebox.sendKeys(fname);
		lastNamebox.sendKeys(lname);
		emailbox.sendKeys(email);
		mobileNumberbox.sendKeys(mNumber);
		proceedtopay.click();

	}

}
