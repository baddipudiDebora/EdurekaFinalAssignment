package com.goibibo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.base.BaseClass;

public class PaymentPage extends BaseClass {
	// cardNumber
	@FindBy(xpath = "(//input[@type='text' and @placeholder='Card Number'])[1]")
	private WebElement cardNumber;

	// NameonCard
	@FindBy(xpath = "(//input[@type='text' and @placeholder='Name'])[1]")
	private WebElement NameonCard;

	// expiryDate
	@FindBy(xpath = "(//input[@type='text' and @placeholder='MM / YY'])[1]")
	private WebElement expiryDate;

	// cvvcode
	@FindBy(xpath = "//input[@type='password' and @placeholder='CVV NO.']")
	private WebElement cvvcode;

	// paymentButton
	@FindBy(xpath = "//button[@class='button green large citipatBtn btn payNowBtn']")
	private WebElement paymentButton;

	// errorforname
	@FindBy(xpath = "//p[contains(text(),'Please Enter')]")
	private WebElement errorforname;

	// constructor
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterPaymentDetails(String cnum, String cname, String cexpiryDate, String invalidcvvcode)
			throws InterruptedException {
		//scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		cardNumber.sendKeys(cnum);
		
		cardNumber.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		// expiryDate.sendKeys(cexpiryDate);
		// cvvcode.sendKeys(invalidcvvcode);
		// paymentButton.click();

	}

	public String getErrorMsg() {

		return errorforname.getText();
	}

}
