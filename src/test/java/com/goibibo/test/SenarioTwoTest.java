package com.goibibo.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;

public class SenarioTwoTest extends BaseClass {
	//Senario 2  -->  Book for a hotel stay for one adult in Ooty,
	//wherein the stay should be more than a day. Fill in dummy card details while making the payment
	//and observe the error message  
	@Test(priority = 1)
	public void invalidPaymentError() throws InterruptedException {
		Thread.sleep(5000);
		landingpageobj.closePopUpWindow();
		Thread.sleep(2000);
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
		Thread.sleep(3000);
		hotelsViewPageobj.getHotelsCount();
		hotelsViewPageobj.clickOnFirstHotel();
		Thread.sleep(3000);
		singleHotelViewPageobj.selectRoom();
		proceedtoPaymentPageobj.enterBookingDetails("Swaroop","Baddipudi","swarp.k@gmail.com","9857856765");
		
		Thread.sleep(3000);
		paymentPageobj.enterPaymentDetails("@sdfg4356", "       ", "12/22", "678");
		System.out.println(paymentPageobj.getErrorMsg());

	}

}
