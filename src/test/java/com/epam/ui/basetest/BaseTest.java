package com.epam.ui.basetest;

import com.epam.ui.factories.BrowserType;
import com.epam.ui.factories.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setUp(BrowserType browserType){
        driver=DriverFactory.createDriver(browserType);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
