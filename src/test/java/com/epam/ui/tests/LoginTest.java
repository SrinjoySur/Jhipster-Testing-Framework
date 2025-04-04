package com.epam.ui.tests;
import com.epam.ui.basetest.BaseTest;
import com.epam.ui.basepages.BasePage;
import com.epam.ui.exceptions.DriverNotFoundException;
import com.epam.ui.listeners.TestExecutionListener;
import com.epam.ui.pages.HomePage;
import com.epam.ui.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Epic("Web Application Regression Testing")
@Feature("Login Page Tests")
public class LoginTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "homePageRedirectionTest",description = "Redirects from HomePage to LoginPage",priority = 1)
    @Description("Home Page Redirects to Login/Sign IN Page")
    @Story("Redirects to Login Page")
    void homePageRedirectionTest(){
        try {
            logger.info("HomePage Test Started");
            HomePage homePage = new HomePage(driver);
            homePage.clickSignIn();
            String actual = homePage.verifyTitle();
            assertEquals(actual, "Sign in");
            logger.info("HomePage Test Successful");
        } catch (Exception e) {
            logger.error("HomePage Test Failed Due to Exception");
            throw new DriverNotFoundException(e.getMessage());
        }
    }
    @Severity(SeverityLevel.BLOCKER)
    @Test(testName = "ValidLoginTest", priority = 2)
    @Parameters({"username","password","rememberMe"})
    @Description("Test Description : Login Test with valid credentials")
    @Story("Successful Login to Application")
    @Step("Logs In to The Application")
    void validLoginTest(String username,String password,Boolean rememberMe){
        try {
            logger.info("Login Page Test Started");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password, rememberMe);
            String actual = loginPage.verifyTitle();
            assertEquals(actual, "Welcome, Java Hipster!");
            logger.info("Login Page Test Successful");
        } catch (Exception e) {
            logger.error("Login Page Test Failed Due To Exception");
            throw new DriverNotFoundException(e.getMessage());
        }
    }
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "InvalidLoginTest")
    @Parameters({"username","password","rememberMe"})
    @Description("Test Description : Login Test with valid credentials")
    @Story("Successful Login to Application")
    @Step("Logs In to The Application")
    void invalidLoginTest(String username,String password,Boolean rememberMe){

    }
}
