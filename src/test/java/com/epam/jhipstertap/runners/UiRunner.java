package com.epam.jhipstertap.runners;

import com.epam.jhipstertap.utils.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"src/test/resources/features/ui"},
        glue = {"com.epam.jhipstertap.ui.stepdefinitions","com.epam.jhipstertap.hooks"},
        plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class UiRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters({"Browser"})
    void setBrowser(String browser){
        ConfigReader reader=ConfigReader.getInstance();
        reader.setBrowser(browser);
    }
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
