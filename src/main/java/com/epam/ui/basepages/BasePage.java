package com.epam.ui.basepages;

import com.epam.ui.factories.BrowserType;
import com.epam.ui.factories.DriverFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.epam.ui.utils.CommonUtils.getTitle;

public abstract class BasePage {
    private static WebDriver driver;
    protected BasePage(BrowserType browserType){
        driver=DriverFactory.createDriver(browserType);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void getUrlDriver(String url){
        getDriver().get(url);
    }
    public void getImplicitlyWait(int durations){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durations));
    }
    public Wait<WebDriver> getWait(int durations){
        return new WebDriverWait(driver, Duration.ofSeconds(durations));
    }
    public Wait<WebDriver> getWait(int durations,int poll){
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(durations)).pollingEvery(Duration.ofSeconds(poll)).ignoring(TimeoutException.class);
    }
    public String verifyTitle(){
        return getTitle(getDriver());
    }
    public void quitDriver(){
        getDriver().quit();
    }
}
