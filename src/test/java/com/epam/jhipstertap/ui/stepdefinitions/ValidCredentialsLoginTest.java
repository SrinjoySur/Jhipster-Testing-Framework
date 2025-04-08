package com.epam.jhipstertap.ui.stepdefinitions;

import com.epam.jhipstertap.hooks.WebDriverHook;
import com.epam.jhipstertap.ui.pages.HomePage;
import com.epam.jhipstertap.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidCredentialsLoginTest {
    private final WebDriver driver=WebDriverHook.getDriver();
    private LoginPage loginPage;
    @Step("User Navigates to Login Page")
    @Given("User with valid Credentials navigates to Login Page")
    public void userNavigatesToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @Step("User Enters Valid Credentials")
    @When("User enters valid Username {string}, valid Password {string} and RememberMe {string}")
    public void userEntersUsernamePasswordAndRememberMe(String username, String password, String rememberMe) {
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }
    @Step("User is successfully redirected to Logged In Homepage")
    @Then("Page Title After Successfully Login In will be {string}")
    public void pageTitleAfterSuccessfullyLoginInWillBe(String title) {
        String actual=loginPage.verifyTitle();
        Assert.assertEquals(actual,title);
    }

}
