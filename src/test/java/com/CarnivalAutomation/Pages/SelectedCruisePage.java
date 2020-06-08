package com.CarnivalAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SelectedCruisePage extends BasePage {
    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public SelectedCruisePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id = "sm-itin")
    private WebElement itineraryTab;

    @FindBy(css = "#sm-booking-btn booking-button")
    private WebElement bookingButton;

    @FindBy(css = "div.tile .about-cta")
    private List<WebElement> daysLearnMoreButton;

    /**
     * Method to check if itinerary tab is displayed
     *
     * @return true if is visible
     */
    public boolean isItineraryTabVisible(){
        return isElementVisible(itineraryTab,5);
    }

    /**
     * Method to check if learn more button is present in all itinerary days
     *
     * @return true if is visible un all elements
     */
    public boolean isLearnMoreButtonVisibleInAllDays(){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(daysLearnMoreButton)));
        return daysLearnMoreButton.stream().allMatch(WebElement::isDisplayed);
    }

    /**
     * Method to check if book now button  is displayed
     *
     * @return true if it is displayed
     */
    public boolean isBookNowButtonVisible(){
        return isElementVisible(bookingButton,10);
    }

    /**
     * Click on booking page button
     *
     * @return instance of BookingPage page object
     */
    public BookingPage tapOnBookingButton(){
        clickElement(bookingButton);
        explicitWaitInSeconds(3);
        return new BookingPage(getDriver());
    }
}
