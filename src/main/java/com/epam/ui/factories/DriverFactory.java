package com.epam.ui.factories;

import com.epam.ui.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static WebDriver createDriver(BrowserType browserType){
        switch (browserType){
            case EDGE: return new EdgeDriver();
            case CHROME: return new ChromeDriver();
            case SAFARI: return new SafariDriver();
            case FIREFOX: return new FirefoxDriver();
            default: throw new DriverNotFoundException("No Such Driver Available");
        }
    }
}
