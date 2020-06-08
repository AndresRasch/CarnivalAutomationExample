package com.CarnivalAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage{
    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public BookingPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "div.dest div.va-content")
    private WebElement bookingSummary;

    @FindBy(css = "div.dest div.date")
    private WebElement bookingDate;

    @FindBy(css = "div.booking-engine-navigation")
    private WebElement bookingProcessSidebar;

    public boolean isBookingSummaryVisible(){
        return isElementVisible(bookingSummary,5);
    }

    public boolean isBookingDateVisible(){
        return isElementVisible(bookingDate,5);
    }

    public boolean isBookingProcessSidebarVisible(){
        return isElementVisible(bookingProcessSidebar,5);
    }
}
