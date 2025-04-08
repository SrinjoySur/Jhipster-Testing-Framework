package com.epam.jhipstertap.ui.base;

import lombok.Getter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.jhipstertap.utils.WebDriverUtils.getTitle;

public abstract class BasePage {
    @Getter
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver=driver;
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