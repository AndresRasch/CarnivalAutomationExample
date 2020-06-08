package com.CarnivalAutomation.Tests;

import com.CarnivalAutomation.Driver;
import com.CarnivalAutomation.Pages.CarnivalHomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    private Driver myDriver;
    private CarnivalHomePage homePage;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser","url"})
    public void beforeTest(String browser, String url) {
        myDriver = new Driver(browser);
        myDriver.getDriver().manage().window().maximize();
        homePage = new CarnivalHomePage(myDriver.getDriver(),url);
    }

    @AfterSuite(alwaysRun=true)
    public void afterSuite() {
        if(myDriver.getDriver() != null){
            myDriver.getDriver().quit();
        }
    }

    /**
     * get initial home page
     *
     * @return  instance of CarnivalHomePage page object
     */
    public CarnivalHomePage getHomePage(){
        return homePage;
    }
}
