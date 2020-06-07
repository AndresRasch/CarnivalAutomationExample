package com.CarnivalAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor.
     * @param pDriver : WebDriver
     */
    public BasePage (WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 20);
        driver = pDriver;
    }

    /**
     * Get the  web driver.
     * @return WebDriver
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Get the  web driver wait.
     * @return WebDriverWait
     */
    public WebDriverWait getWait() {
        return wait;
    }
    /**
     * Close the web driver.
     */
    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void implicitWaitInSeconds(long timeOut){
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }
}
