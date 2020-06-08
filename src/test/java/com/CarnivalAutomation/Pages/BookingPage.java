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

    @FindBy(css = "div[data-testid=\"itinDates\"]")
    //@FindBy(css = "div.dest div.date")
    private WebElement bookingDate;

    @FindBy(css = "div[data-testid=\"itinShip\"]")
    //@FindBy(css = "div.booking-engine-navigation")
    private WebElement bookingSummary;

    @FindBy(css = "h1[data-testid=\"lowestPriceHeader\"]")
    //@FindBy(css = "LowestPriceDialogTitle")
    private WebElement priceGuaranteeDialog;

    @FindBy(css = "button[data-testid=\"greatVacation\"]")
    //@FindBy(css = "div.white-ribbon ul li:first-child")
    private WebElement vacationGuaranteeButton;


    @FindBy(css = "button[data-testid=\"lowestPrice\"]")
    //@FindBy(css = "div.white-ribbon ul li:nth-child(2)")
    private WebElement priceGuaranteeButton;

    @FindBy(css = "button[data-testid=\"greatVacationCloseButton\"]")
    //@FindBy(css = "div.modal-footer button")
    private WebElement closeDialogVacationButton;

    @FindBy(css = "button[data-testid=\"lowestPriceCloseButton\"]")
    //@FindBy(css = "div.modal-footer button")
    private WebElement closeDialogPriceButton;


    @FindBy(css = "h1[data-testid=\"greatVacationHeader\"]")
    //@FindBy(id = "GreatVacationGuaranteeDialogTitle")
    private WebElement vacationGuaranteeDialog;



    public boolean isBookingSummaryVisible(){
        return isElementVisible(bookingSummary,5);
    }

    public boolean isBookingDateVisible(){
        return isElementVisible(bookingDate,5);
    }

    public boolean isPriceGuaranteeDialogVisible(){
        clickElement(priceGuaranteeButton);
        explicitWaitInSeconds(2);
        boolean isVisible = isElementVisible(priceGuaranteeDialog,10);
        clickElement(closeDialogPriceButton);
        return isVisible;
    }

    public boolean isVacationGuaranteeDialogVisible(){
        clickElement(vacationGuaranteeButton);
        explicitWaitInSeconds(2);
        boolean isVisible = isElementVisible(vacationGuaranteeDialog,10);
        clickElement(closeDialogVacationButton);
        return isVisible;
    }
}
