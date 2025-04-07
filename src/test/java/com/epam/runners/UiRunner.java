package com.epam.runners;

import com.epam.ui.factories.BrowserType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"src/test/resources/features/ui"},
        glue = {"com.epam.ui.stepdefinitions","com.epam.hooks"},
        plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class UiRunner extends AbstractTestNGCucumberTests {
//    private BrowserType browser;
//    @BeforeSuite
//    @Parameters({"browser"})
//    void setBrowser(@Optional(value="CHROME") BrowserType browser){
//        this.browser=browser;
//    }
//    public BrowserType getBrowser() {
//        return browser;
//    }
}
