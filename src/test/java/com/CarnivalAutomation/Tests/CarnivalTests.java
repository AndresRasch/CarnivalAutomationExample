package com.CarnivalAutomation.Tests;

import com.CarnivalAutomation.Pages.CarnivalHomePage;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

public class CarnivalTests extends BaseTest{

    private CarnivalHomePage carnivalHomePage;

    @BeforeClass()
    public void getHomePage(String url){
        carnivalHomePage = getHomePage();
    }

    @Test
    public void holaMundo(){
        System.out.println("Hola Mundo!");
    }
}
