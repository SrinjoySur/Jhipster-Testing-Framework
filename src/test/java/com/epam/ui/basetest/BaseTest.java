package com.epam.ui.basetest;

import com.epam.ui.factories.BrowserType;
import com.epam.ui.factories.DriverFactory;
import com.epam.ui.listeners.TestExecutionListener;
import groovy.util.logging.Log4j2;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.Duration;
@Listeners({TestExecutionListener.class})
@Log4j2
public class BaseTest {
    public WebDriver driver;
    protected static DriverFactory factory;
    protected Logger logger=LogManager.getLogger(BaseTest.class);
    @Step("Start the application")
    @Parameters("browser")
    @BeforeTest
    public void setUp(BrowserType browser){
        factory = DriverFactory.getInstance(browser);
        driver = factory.getDriver();
        driver.get("http://localhost:9000/");
    }
    @Step("Stop the application")
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
