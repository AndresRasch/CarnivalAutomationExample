package com.CarnivalAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchSailResultPage extends BasePage {

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public SearchSailResultPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id = "sfn-nav-pricing")
    private WebElement pricingTab;

    @FindBy(css = "span.rz-pointer-min")
    private WebElement minPriceOption;

    @FindBy(css = "div.sbls-container__layout-switchers > a:first-child")
    private WebElement gridViewButton;

    @FindBy(css = "div.vrg-search-unit a.vrgf-learn-more__text")
    private List<WebElement> cruisesLearnMoreButtons;


    /**
     * Method to check if pricing filter tab is displayed
     *
     * @return true if it is displayed
     */
    public boolean isPricingButtonVisible(){
       return isElementVisible(pricingTab,5);
    }

    /**
     * Method to check if min price filter is displayed by default
     *
     * @return true if it is displayed
     */
    public boolean isMinPricingValueSelected(){
        clickElement(pricingTab);
        return isElementVisible(minPriceOption,5);
    }

    /**
     * Method to check if grid view is enabled by default
     *
     * @return true if it is displayed
     */
    public boolean isGridViewSelected(){
        getWait().until(ExpectedConditions.visibilityOf(gridViewButton));
        return gridViewButton.isEnabled();
    }

    /**
     * Method to select a sail cruise by index
     *
     * @return a instance of SelectedCruisePage page object
     */
    public SelectedCruisePage selectCruise(int option){
        getWait().until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfAllElements(cruisesLearnMoreButtons)));

        cruisesLearnMoreButtons.get(option).click();
        return new SelectedCruisePage(getDriver());
    }
}
