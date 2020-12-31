package com.goibibo.test;

import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;

public class SearchHotelsTest extends BaseClass {
	@Test(priority = 1)
	public void validEmailForgotTest() throws InterruptedException {
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		hotelBookingPageobj.enterCheckInDate();
		//	hotelBookingPageobj.enterCheckOutDate();
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
	}
	
}
