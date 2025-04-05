package com.epam.runners;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.epam.ui.stepdefinitions","com.epam.hooks"},
        plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports.html"}
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
