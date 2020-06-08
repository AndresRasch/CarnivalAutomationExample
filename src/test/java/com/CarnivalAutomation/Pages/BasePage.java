package com.CarnivalAutomation.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    public void clickElement(WebElement clickableElement) {
        wait.until(ExpectedConditions.visibilityOf(clickableElement));
        clickableElement.click();
    }

    public void clickElement(WebElement clickableElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);

        try {
            wait.until(ExpectedConditions.visibilityOf(clickableElement));
            clickableElement.click();
        }catch (TimeoutException ignored) {
        } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            System.err.println("Page.isElementVisible: StaleElementException caught" );
        } catch (Exception error) {
            System.err.println("Page.isElementVisible: Exception caught "+error.getMessage() );
        }

    }

    public void setTextToElement(WebElement editableElement, String text) {
        editableElement.clear();
        editableElement.sendKeys(text);
    }


    public WebElement getParentElement(WebElement childElement) {
        return (WebElement) ((JavascriptExecutor) driver).
                executeScript("return arguments[0].parentNode;", childElement);

    }

    public boolean isElementVisible(WebElement element, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException ignored) {
            return false;
        } catch (org.openqa.selenium.StaleElementReferenceException ignored) {
            System.err.println("Page.isElementVisible: StaleElementException caught" );
            return false;
        } catch (Exception error) {
            System.err.println("Page.isElementVisible: Exception caught "+error.getMessage() );
            return false;
        }
    }
}
