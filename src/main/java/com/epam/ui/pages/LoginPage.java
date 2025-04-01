package com.epam.ui.pages;

import com.epam.ui.basepages.BasePage;
import com.epam.ui.factories.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.epam.ui.utils.CommonUtils.*;

public class LoginPage extends BasePage {
    LoginPage(BrowserType browserType){
        super(browserType);
    }
    private By userName=By.id("username");
    private By passWord=By.id("password");
    private By submitButton= By.cssSelector("button[type='submit']");
    public WebDriver login(String username,String password){
        WebElement user=findWebElement(getDriver(),userName);
        WebElement pass=findWebElement(getDriver(),passWord);
        WebElement submit=findWebElement(getDriver(),submitButton);
        sendKeys(user,username);
        sendKeys(pass,password);
        click(submit);
        return getDriver();
    }
}
