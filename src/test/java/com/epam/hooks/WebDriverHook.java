package com.epam.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHook {
    protected WebDriver driver;
    TestCon
    @BeforeAll
    public void before(){
        driver=new ChromeDriver();
        driver.get("http://localhost:9000/");
        driver.manage().window().maximize();
    }
    @AfterAll
    public void teardown(){
        driver.quit();
    }
}
