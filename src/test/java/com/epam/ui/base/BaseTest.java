package com.epam.ui.base;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    @BeforeAll
    void setUp(){
        driver=new ChromeDriver();
        driver.get("http://localhost:9000/");
        driver.manage().window().maximize();
    }
    @AfterAll
    void teardown(){
        driver.quit();
    }
}
