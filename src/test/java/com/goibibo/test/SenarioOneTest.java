package com.goibibo.test;

import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;

public class SenarioOneTest extends BaseClass {
	//Senario 1 --> Search a hotel for one adult and log the hotel's name in TestNG
	@Test(priority = 1)
	public void hotelSearchandView() throws InterruptedException {
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		//hotelBookingPageobj.enterCheckInDate();
		// hotelBookingPageobj.enterCheckOutDate();
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
		Thread.sleep(3000);
		hotelsViewPageobj.getHotelsCount();
		hotelsViewPageobj.getFirstHotelName();
		hotelsViewPageobj.clickOnFirstHotel();
	}

}
