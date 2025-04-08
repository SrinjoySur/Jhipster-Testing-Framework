package com.epam.jhipstertap.ui.stepdefinitions;

import com.epam.jhipstertap.constants.ConfigProvider;
import com.epam.jhipstertap.hooks.WebDriverHook;
import com.epam.jhipstertap.ui.pages.HomePage;
import com.epam.jhipstertap.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.epam.jhipstertap.utils.ScreenshotUtils.getCount;
import static com.epam.jhipstertap.utils.ScreenshotUtils.saveScreenshot;

public class InvalidCredentialsTest {
    private final WebDriver driver= WebDriverHook.getDriver();
    private LoginPage loginPage;
    @Step("User Navigates to Login Page")
    @Given("User with invalid Credentials navigates to Login Page")
    public void userNavigatesToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }
    @Step("User Enters Invalid Credentials")
    @When("User enters invalid Username {string}, invalid Password {string} and RememberMe {string}")
    public void userEntersInvalidUsernameInvalidPasswordAndRememberMe(String username, String password, String rememberMe) {
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }
    @Step("User get Login Failure Message")
    @SneakyThrows
    @Then("Page will display message {string}")
    public void pageWillDisplayMessage(String message) {
        String actual=loginPage.invalidMessage();
        Assert.assertEquals(actual,message);
        saveScreenshot(driver);
        try(InputStream is= Files.newInputStream(Paths.get(ConfigProvider.getScreenshotsDirPath()+"/failure"+getCount()+"_screenshot.png"))){
            Allure.addAttachment(driver.getTitle()+"_"+getCount()+"_failed.png",is);
        }
    }
}
