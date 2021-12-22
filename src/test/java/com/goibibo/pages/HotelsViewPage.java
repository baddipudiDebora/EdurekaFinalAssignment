package com.goibibo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsViewPage {
	// hotelsDisplayGrid
	@FindBy(xpath = "//div[@class='HotelCardstyles__WrapperSectionMetaDiv-sc-1s80tyk-5 jizVXu']")
	private List<WebElement> hotelsdisplayGrid;;

	// hotelnameDisplayed
	@FindBy(xpath = "//h4[@itemprop='name']")
	private WebElement hotelName;

	// PayAtHotelfilter
	@FindBy(xpath = "//span[contains(text(),'Pay At Hotel Available')]")
	private WebElement PayAtHotelfilter;
	
	//price range filter
	@FindBy(xpath = "//span[@class='CheckBoxList__CheckBoxListText-sc-5k7440-6 fNzzGJ' and contains(text(),'2001')]")
	private WebElement priceRangeFilter;
	
	// customer4rating
	@FindBy(xpath = "(//span[@class= 'Filtersstyles__AverageReviewText-sc-bkjigy-8 kmeHqf' and contains(text(),\"4\")])[2]")
	private WebElement customer4rating;

	// payAtHotel
	@FindBy(xpath="//span[contains(text(),'Pay At Hotel Available')]") 
	private WebElement payAtHotel;
	 
	// UpdateSearchButton
	
	@FindBy(xpath="//button[contains(text(),'UPDATE SE')]") 
	private WebElement UpdateSearchButton;
	
	//filtersApplied
	@FindBy(xpath="//div[@class='Chip-sc-o2aze2-0 dkdfSR']") 
	private List <WebElement> filtersApplied;
	
	
	// constructor
	public HotelsViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
// all methods written here
	public void getHotelsCount() throws InterruptedException {
		System.out.println("The number of hotes with for this search is " + hotelsdisplayGrid.size());
	}

	public void clickOnFirstHotel() throws InterruptedException {
		hotelsdisplayGrid.get(0).click();
	}

	public void getFirstHotelName() throws InterruptedException {
		String firstHotel = hotelName.getText();
		System.out.println("The first Displayed Hotel is " + firstHotel);
	}
   public void selectPriceRange()  {
	   try {
		Thread.sleep(3000);
		   System.out.println("workign fine till select price range");
		   priceRangeFilter.click();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }
	
	public void clickOnCustomer4rating() {
		  System.out.println("workign fine till select customer rating range");
		customer4rating.click();
	}
	public void clickOnpayAtHotel()  {
		
		payAtHotel.click();
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickUpdateSearchButton() {
		UpdateSearchButton.click();
	}
	public void getfiltersApplied() {
		
		int numberofFiltersApplied = filtersApplied.size();
		for (int i=0;i<numberofFiltersApplied-1 ; i++) {
			System.out.println(filtersApplied.toString());	
		}
		
	}
}
