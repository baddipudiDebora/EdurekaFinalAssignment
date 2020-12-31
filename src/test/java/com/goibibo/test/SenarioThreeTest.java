package com.goibibo.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;
import com.goibibo.pages.SingleHotelsViewPage;

public class SenarioThreeTest extends BaseClass {
	//Senario 2  -->  Search for a hotel and 
	//select the first the hotel to get the details on the rooms and rates, location, guest reviews, questions
	//and answers and hotel policies 
	@Test(priority = 1)
	public void hotelAndRoomDetials() throws InterruptedException {
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		hotelBookingPageobj.enterCheckInDate();
		// hotelBookingPageobj.enterCheckOutDate();
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
		Thread.sleep(3000);
		hotelsViewPageobj.clickOnFirstHotel();
		// code to switch to anothter tab
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iterator = ids.iterator();
		String parentID = iterator.next();
		String childID = iterator.next();
		driver.switchTo().window(childID);
		singleHotelViewPageobj.getFirstHotelName();
		singleHotelViewPageobj.gethotelAddress();
		singleHotelViewPageobj.gethotelRating();
		singleHotelViewPageobj.viewRooms();
		singleHotelViewPageobj.getRoomDetials();
		
		singleHotelViewPageobj.getQuestionAndAns();
		
		

	}

}
