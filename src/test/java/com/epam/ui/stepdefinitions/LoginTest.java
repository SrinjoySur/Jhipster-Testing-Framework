package com.epam.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @Given("User navigates to Login Page")
    public void userNavigatesToLoginPage() {
        driver=new ChromeDriver();
        driver.get("http://localhost:9000/");
        driver.manage().window().maximize();
        driver.findElement(By.className("alert-link")).click();
    }


    @When("User enters Username {string}, Password {string} and RememberMe {string}:")
    public void userEntersUsernamePasswordAndRememberMe(String username, String password, String rememberMe) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        if(rememberMe.equals("true")){
            driver.findElement(By.id("rememberMe")).click();
        }
        driver.findElement(By.cssSelector("button.btn")).click();
    }

    @Then("Page Title After Successfully Login In will be {string}")
    public void pageTitleAfterSuccessfullyLoginInWillBe(String title) {
        Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
        driver.quit();
    }
}
