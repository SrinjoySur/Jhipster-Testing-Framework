package com.epam.ui.stepdefinitions;

import com.epam.hooks.WebDriverHook;
import com.epam.ui.pages.HomePage;
import com.epam.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {
    private final WebDriver driver=WebDriverHook.getDriver();
    private HomePage homePage;
    private LoginPage loginPage;
    @Given("User navigates to Login Page")
    public void userNavigatesToLoginPage() {
        homePage=new HomePage(driver);
        homePage.clickSignIn();
    }


    @When("User enters Username {string}, Password {string} and RememberMe {string}")
    public void userEntersUsernamePasswordAndRememberMe(String username, String password, String rememberMe) {
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }

    @Then("Page Title After Successfully Login In will be {string}")
    public void pageTitleAfterSuccessfullyLoginInWillBe(String title) {
        String actual=loginPage.verifyTitle();
        Assert.assertEquals(actual,title);
        driver.quit();
    }

    @Then("Page will display message {string}")
    public void pageWillDisplayMessage(String message) {
        Assert.assertEquals("",message);
    }


}
