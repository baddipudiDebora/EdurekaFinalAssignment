package com.goibibo.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;
import com.goibibo.pages.SingleHotelsViewPage;

public class SenarioFourTest extends BaseClass {
	// Senario 4 --> Search for a hotel in Ooty and apply filter based on pay at
	// hotel, with ratings as 4, and first price range. Verify the applied filter
	// change
	@Test(priority = 1)
	public void verifySearchFilter() throws InterruptedException {
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		hotelBookingPageobj.enterCheckInDate();
		// hotelBookingPageobj.enterCheckOutDate();
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
		// select filters
		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		hotelsViewPageobj.clickOnFirstPriceFilter();
		hotelsViewPageobj.clickOnCustomer4rating();
		hotelsViewPageobj.clickOnpayAtHotel();
		hotelsViewPageobj.clickUpdateSearchButton();
	
		hotelsViewPageobj.getfiltersApplied();
	}

}
