package com.CarnivalAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

public class CarnivalHomePage extends BasePage {

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public CarnivalHomePage(WebDriver pDriver, String url) {
        super(pDriver);
        pDriver.get(url);
    }

    @FindBy(id = "cdc-destinations")
    private WebElement destinationTab;

    @FindBy(css = "div.cdc-filter-body button")
    private List<WebElement> tabOptions;

    @FindBy(id = "cdc-durations")
    private WebElement durationTab;

    @FindBy(css = "li a.cdc-filters-search-cta")
    private WebElement searchButton;

    @FindBy(css ="div.vifp-close")
    private WebElement popUpCloseButton;

    public SearchSailResultPage searchCruiseSail(String departurePort, String duration){
        clickElement(destinationTab);
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(tabOptions)));
        Optional<WebElement> destinationToTap = tabOptions.stream().
                filter(option -> option.getText().contains(departurePort)).findFirst();
        destinationToTap.ifPresent(WebElement::click);

        clickElement(durationTab);
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(tabOptions)));
        Optional<WebElement> durationToTap = tabOptions.stream().
                filter(option -> option.getText().contains(duration)).findFirst();
        durationToTap.ifPresent(WebElement::click);

        clickElement(searchButton);

        return new SearchSailResultPage(getDriver());
    }

    public void dismissPopUp() {
        new Actions(getDriver()).moveByOffset(0, 0).click().build().perform();
    }
}
