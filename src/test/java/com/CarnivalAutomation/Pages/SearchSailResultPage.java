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


    public boolean isPricingButtonVisible(){
       return isElementVisible(pricingTab,5);
    }

    public boolean isMinPricingValueSelected(){
        clickElement(pricingTab);
        return isElementVisible(minPriceOption,5);
    }

    public boolean isGridViewSelected(){
        getWait().until(ExpectedConditions.visibilityOf(gridViewButton));
        return gridViewButton.isEnabled();
    }

    public SelectedCruisePage selectCruise(int option){
        getWait().until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfAllElements(cruisesLearnMoreButtons)));

        cruisesLearnMoreButtons.get(option).click();
        return new SelectedCruisePage(getDriver());
    }
}
