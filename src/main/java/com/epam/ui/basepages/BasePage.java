package com.epam.ui.basepages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static com.epam.ui.utils.CommonUtils.getTitle;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver=driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void getUrlDriver(String url){
        getDriver().get(url);
    }
    public void getImplicitlyWait(int durations){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(durations));
    }
    public Wait<WebDriver> getWait(int durations){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(durations));
    }
    public Wait<WebDriver> getWait(int durations,int poll){
        return new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(durations)).pollingEvery(Duration.ofSeconds(poll)).ignoring(TimeoutException.class);
    }
    public String verifyTitle(){
        return getTitle(getDriver());
    }
    public void closeDriver(){
        getDriver().close();
    }
}
