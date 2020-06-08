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

    public boolean isItineraryTabVisible(){
        return isElementVisible(itineraryTab,5);
    }

    public boolean isLearnMoreButtonVisibleInAllDays(){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(daysLearnMoreButton)));
        return daysLearnMoreButton.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isBookNowButtonVisible(){
        return isElementVisible(bookingButton,10);
    }

    public BookingPage tapOnBookingButton(){
        clickElement(bookingButton);
        return new BookingPage(getDriver());
    }
}
