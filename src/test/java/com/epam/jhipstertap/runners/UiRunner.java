package com.epam.jhipstertap.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/ui"},
        glue = {"com.epam.jhipstertap.ui.stepdefinitions","com.epam.jhipstertap.hooks"},
        plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class UiRunner extends AbstractTestNGCucumberTests {

}
