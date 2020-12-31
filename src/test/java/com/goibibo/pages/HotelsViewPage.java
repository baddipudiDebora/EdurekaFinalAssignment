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

	// firstHotelDisplayed
	@FindBy(xpath = "//h4[@itemprop='name']")
	private List<WebElement> firstHotelDisplayed;;

	// constructor
	public HotelsViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getHotelsCount() throws InterruptedException {
		System.out.println("The number of hotes with for this search is " + hotelsdisplayGrid.size());
	}

	public void clickOnFirstHotel() throws InterruptedException {
		hotelsdisplayGrid.get(0).click();
	}

	public void getFirstHotelName() throws InterruptedException {
		String firstHotel = hotelsdisplayGrid.get(0).findElement(By.xpath("//h4[@itemprop='name']")).getText();
		System.out.println("The first Displayed Hotel is "+firstHotel);
	}

}
