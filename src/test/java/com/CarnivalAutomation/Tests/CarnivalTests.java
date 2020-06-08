package com.CarnivalAutomation.Tests;

import com.CarnivalAutomation.Pages.CarnivalHomePage;
import com.CarnivalAutomation.Pages.SearchSailResultPage;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarnivalTests extends BaseTest{

    private CarnivalHomePage carnivalHomePage;
    private SearchSailResultPage searchSailResultPage;


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
}
