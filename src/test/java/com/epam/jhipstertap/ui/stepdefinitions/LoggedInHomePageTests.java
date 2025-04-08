package com.epam.jhipstertap.ui.stepdefinitions;

import com.epam.jhipstertap.hooks.WebDriverHook;
import com.epam.jhipstertap.ui.pages.HomePage;
import com.epam.jhipstertap.ui.pages.Jhipster_Logged_In_HomePage;
import com.epam.jhipstertap.ui.pages.LoginPage;
import groovy.util.logging.Log4j2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;
@Log4j2
public class LoggedInHomePageTests {
    Logger logger= LogManager.getLogger(this.getClass());
    WebDriver driver= WebDriverHook.getDriver();
    private LoginPage loginPage;
    private Jhipster_Logged_In_HomePage loggedInHomePage;
    @Step("User Navigates to Login Page")
    @Given("User is on HomePage and presses sign in")
    public void userIsOnHomePageAndPressesSignIn() {
        logger.info("User navigation to login page started");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
        logger.info("User navigation to login page complete");
    }
    @Step("User Enters Valid Credentials")
    @And("User enters valid username , valid password and rememberMe:")
    public void userEntersValidUsernameValidPasswordAndRememberMe(DataTable dataTable) {
        Map<String,String> credentials=dataTable.asMap(String.class, String.class);
        String username=credentials.get("username");
        String password=credentials.get("password");
        String rememberMe= credentials.get("rememberMe");
        loginPage=new LoginPage(driver);
        loginPage.login(username,password, Boolean.valueOf(rememberMe));
    }
    @Step("User is successfully redirected to Logged In Homepage")
    @And("User is now Logged in to the page with Title {string}")
    public void userIsNowLoggedInToThePageWithTitle(String title) {
        String actual=loginPage.verifyTitle();
        Assert.assertEquals(actual,title);
    }
    @Step("User Goes to the BanK Account Page")
    @When("User navigates to Bank Account Page")
    public void userNavigatesToBankAccountPage() {
        loggedInHomePage=new Jhipster_Logged_In_HomePage(driver);
        loggedInHomePage.goToBankAccountPage();
    }
    @Step("User is Successfully Redirected to Bank Account Page")
    @Then("User gets Page Title as {string}")
    public void userGetsPageTitleAs(String title) {
        String actualTitle=loggedInHomePage.verifyTitle();
        Assert.assertEquals(actualTitle,title);
    }

}
