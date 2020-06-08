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

    @FindBy(id = "LowestPriceDialogTitle")
    private WebElement priceGuaranteeDialog;

    @FindBy(css = "div.white-ribbon ul li:first-child")
    private WebElement priceGuaranteeButton;


    @FindBy(css = "div.white-ribbon ul li:nth-child(2)")
    private WebElement vacationGuaranteeButton;

    @FindBy(css = "div.modal-footer button")
    private WebElement closeDialogButton;

    @FindBy(id = "GreatVacationGuaranteeDialogTitle")
    private WebElement vacationGuaranteeDialog;



    public boolean isBookingSummaryVisible(){
        return isElementVisible(bookingSummary,5);
    }

    public boolean isBookingDateVisible(){
        return isElementVisible(bookingDate,5);
    }

    public boolean isBookingProcessSidebarVisible(){
        return isElementVisible(bookingProcessSidebar,5);
    }

    public boolean isPriceGuaranteeDialogVisible(){
        clickElement(priceGuaranteeButton);
        boolean isVisible = isElementVisible(priceGuaranteeDialog,10);
        clickElement(closeDialogButton);
        return isVisible;
    }

    public boolean isVacationGuaranteeDialogVisible(){
        explicitWaitInSeconds(3);
        clickElement(vacationGuaranteeButton);
        boolean isVisible = isElementVisible(vacationGuaranteeDialog,10);
        clickElement(closeDialogButton);
        return isVisible;
    }
}
