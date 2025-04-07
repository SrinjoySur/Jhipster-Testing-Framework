package com.epam.hooks;

import com.epam.runners.UiRunner;
import com.epam.ui.factories.BrowserType;
import com.epam.ui.factories.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class WebDriverHook {
    private static WebDriver driver;
    UiRunner runner=new UiRunner();
    DriverFactory driverFactory=DriverFactory.getInstance(BrowserType.CHROME);
    @Before
//    @Parameters({"browser"})
    public void before(){
//        driverFactory=DriverFactory.getInstance(browser);
        driver= driverFactory.getDriver();
        driver.get("http://localhost:9000/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }
    @After
    public void teardown(){
        driverFactory.quitDriver();
        driver.quit();
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Make sure setUp() is executed before calling getDriver().");
        }
        return driver;
    }
}
