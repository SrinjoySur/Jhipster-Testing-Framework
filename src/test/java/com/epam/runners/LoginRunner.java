package com.epam.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.epam.ui.stepdefinitions"},
        plugin = {}
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
