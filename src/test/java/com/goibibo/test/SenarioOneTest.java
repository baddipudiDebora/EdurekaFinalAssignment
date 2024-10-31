package com.goibibo.test;

import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;

public class SenarioOneTest extends BaseClass {
	//Senario 1 --> Search a hotel for one adult and log the hotel's name in TestNG
	@Test(priority = 1)
	public void hotelSearchandView() throws InterruptedException {
		Thread.sleep(5000);
		landingpageobj.closePopUpWindow();
		Thread.sleep(2000);
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		//hotelBookingPageobj.enterCheckInDate();
		// hotelBookingPageobj.enterCheckOutDate();
//		hotelBookingPageobj.closeQRCode();
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
		Thread.sleep(3000);
		hotelsViewPageobj.getHotelsCount();
		hotelsViewPageobj.clickOnFirstHotel();
	}

}
