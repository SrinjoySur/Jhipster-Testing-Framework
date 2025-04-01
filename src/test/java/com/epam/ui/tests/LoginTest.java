package com.epam.ui.tests;
import com.epam.ui.basetest.BaseTest;
import com.epam.ui.basepages.BasePage;
import com.epam.ui.factories.BrowserType;
import com.epam.ui.pages.HomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    private HomePage page;
    @Test(testName = "homePageRedirectionTest",description = "Redirects from HomePage to LoginPage")
    @Parameters("browser")
    void homePageRedirectionTest(BrowserType browserType){
        page=new HomePage(browserType);
        driver=page.clickSignIn();
        String actual= page.verifyTitle();
        assertEquals(actual,"Sign in");
    }
//    @Test(dependsOnMethods = "homePageRedirectionTest")
//    void validLoginTest(){
//        HashMap
//
//    }
}
