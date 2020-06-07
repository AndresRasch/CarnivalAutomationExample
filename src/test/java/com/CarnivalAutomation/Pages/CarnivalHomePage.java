package com.CarnivalAutomation.Pages;

import org.openqa.selenium.WebDriver;

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


}
