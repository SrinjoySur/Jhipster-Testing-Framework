package com.epam.ui.factories;

import com.epam.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    private static volatile DriverFactory factory;
    private static final ThreadLocal<WebDriver> local = new ThreadLocal<>();
    private DriverFactory(){}
    private void setDriver(BrowserType browser) {
        switch ((browser)) {
            case CHROME:
                local.set(new ChromeDriver());
                break;
            case FIREFOX:
                local.set(new FirefoxDriver());
                break;
            case EDGE:
                local.set(new EdgeDriver());
                break;
            case SAFARI:
                local.set(new SafariDriver());
                break;
            default:
                throw new DriverNotFoundException("Invalid browser name: " + browser);
        }
    }

    public WebDriver getDriver() {
        return local.get();
    }

    public static DriverFactory getInstance(BrowserType browser) {
        if (factory == null) {
            synchronized (DriverFactory.class) {
                if (factory == null) {
                    factory = new DriverFactory();
                }
            }
        }
        if (local.get() == null) {
            factory.setDriver(browser);
        }
        return factory;
    }

    public void quitDriver() {
        WebDriver driver = local.get();
        if (driver != null) {
            driver.quit();
            local.remove();
        }
    }
}
