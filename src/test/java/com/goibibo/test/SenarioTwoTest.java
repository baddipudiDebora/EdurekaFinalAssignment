package com.goibibo.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.goibibo.base.BaseClass;

public class SenarioTwoTest extends BaseClass {
	@Test(priority = 1)
	public void HotelCount() throws InterruptedException {
		landingpageobj.clickOnHotes();
		hotelBookingPageobj.enterHotels("Ooty");
		hotelBookingPageobj.enterCheckInDate();
		// hotelBookingPageobj.enterCheckOutDate();
		hotelBookingPageobj.enterNumofGuest();
		hotelBookingPageobj.clickOnSearch();
		Thread.sleep(3000);
		hotelsViewPageobj.clickOnFirstHotel();
		Thread.sleep(3000);
		// open the second tab
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		 * Thread.sleep(2000);
		 */
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iterator = ids.iterator();
		String parentID = iterator.next();
	
		String childID = iterator.next();
	

		driver.switchTo().window(childID);
		singleHotelViewPageobj.selectRoom();
		proceedtoPaymentPageobj.enterBookingDetails("Swaroop","Baddipudi","swarp.k@gmail.com","9857856765");
		
		Thread.sleep(3000);
		paymentPageobj.enterPaymentDetails("@sdfg4356", "       ", "12/22", "678");
		System.out.println(paymentPageobj.getErrorMsg());

	}

}
