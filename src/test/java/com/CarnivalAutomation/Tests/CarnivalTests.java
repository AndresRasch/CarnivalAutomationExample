package com.CarnivalAutomation.Tests;

import com.CarnivalAutomation.Pages.BookingPage;
import com.CarnivalAutomation.Pages.CarnivalHomePage;
import com.CarnivalAutomation.Pages.SearchSailResultPage;
import com.CarnivalAutomation.Pages.SelectedCruisePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarnivalTests extends BaseTest{

    private CarnivalHomePage carnivalHomePage;
    private SearchSailResultPage searchSailResultPage;
    private SelectedCruisePage selectedCruisePage;
    private BookingPage bookingPage;


    @Test(description = "CAR001 - Search a single cruise selecting an arrival port and a duration value", priority = 1)
    public void singleCruiseSearch(){
        carnivalHomePage = getHomePage();
        carnivalHomePage.dismissPopUp();
        searchSailResultPage =
                carnivalHomePage.searchCruiseSail("The Bahamas","6 - 9");
        Assert.assertTrue(searchSailResultPage.isGridViewSelected(),"Default grid view is selected");
        Assert.assertTrue(searchSailResultPage.isPricingButtonVisible(),"Pricing tab filter is displayed");
        Assert.assertTrue(searchSailResultPage.isMinPricingValueSelected(),"Min price filter is displayed");
    }

    @Test(description = "CAR002 - Select single cruise from search results",priority = 2)
    public void selectCruiseFromSearchResult(){
       selectedCruisePage = searchSailResultPage.selectCruise(1);
       Assert.assertTrue(selectedCruisePage.isLearnMoreButtonVisibleInAllDays());
       Assert.assertTrue(selectedCruisePage.isItineraryTabVisible());
       Assert.assertTrue(selectedCruisePage.isBookNowButtonVisible());
       bookingPage = selectedCruisePage.tapOnBookingButton();

    }
    /*
    @Test(description = "CAR003 - Book a sail cruise",priority = 3)
    public void bookACruise(){
        Assert.assertTrue(bookingPage.isBookingDateVisible(),"Booking date is displayed");
        Assert.assertTrue(bookingPage.isBookingProcessSidebarVisible(),"Booking process sidebar is displayed");
        Assert.assertTrue(bookingPage.isBookingSummaryVisible(),"Booking summary is displayed");
    }

    @Test(description = "CAR004 - Verify support links on footer section on booking process ",priority = 4)
    public void verifyBookingSupportLinks(){
        Assert.assertTrue(bookingPage.isPriceGuaranteeDialogVisible(),"Price Guarantee pop up is displayed");
        Assert.assertTrue(bookingPage.isVacationGuaranteeDialogVisible(),"Vacation Guarantee pop up is displayed");
    }*/
}
