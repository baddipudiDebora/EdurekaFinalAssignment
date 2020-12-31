package com.goibibo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsViewPage {
	// hotelsDisplayGrid
	@FindBy(xpath = "//div[@itemtype='http://schema.org/Hotel']")
	private List<WebElement> hotelsdisplayGrid;;

	// hotelnameDisplayed
	@FindBy(xpath = "//h4[@itemprop='name']")
	private WebElement hotelName;

	// firstPricefilter
	@FindBy(xpath = "//span[contains(text(),'Upto')]")
	private WebElement firstPriceFilter;
	
	// customer4Plusrating
	@FindBy(xpath = "// div[@class='Filtersstyles__AverageReviewWrapper-bkjigy-8 ipQgCe']")
	private WebElement customer4Plusrating;

	// payAtHotel
	@FindBy(xpath="//span[contains(text(),'Pay At Hotel Available')]") 
	private WebElement payAtHotel;
	 
	// UpdateSearchButton
	
	@FindBy(xpath="//button[contains(text(),'UPDATE SE')]") 
	private WebElement UpdateSearchButton;
	
	//filtersApplied
	@FindBy(xpath="//div[@class='Filtersstyles__AppliedFiltersWrapperDiv-bkjigy-4 KEtAE']") 
	private WebElement filtersApplied;
	
	
	// constructor
	public HotelsViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
// all methods writtten here
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
	public void clickOnFirstPriceFilter() {
		firstPriceFilter.click();
	}
	public void clickOnCustomer4rating() {
		customer4Plusrating.click();
	}
	public void clickOnpayAtHotel() {
		payAtHotel.click();
	}
	public void clickUpdateSearchButton() {
		UpdateSearchButton.click();
	}
	public void getfiltersApplied() {
		String appliedfiltersAre = filtersApplied.getText();
		System.out.println(appliedfiltersAre);
	}
}
