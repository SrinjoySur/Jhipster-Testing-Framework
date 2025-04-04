package com.epam.ui.pages;

import com.epam.ui.basepages.BasePage;
import com.epam.ui.factories.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import static com.epam.ui.utils.CommonUtils.*;

public class HomePage extends BasePage {
    private final String url="http://localhost:9000/";
    public HomePage(WebDriver driver){
        super(driver);
    }
    private final By signIn=By.linkText("sign in");
    public WebDriver clickSignIn(){
        getUrlDriver(url);
        WebElement element=findWebElement(getDriver(),signIn);
        click(element);
        return getDriver();
    }
    @Override
    public String verifyTitle(){
        Wait<WebDriver> wait=getWait(120);
        wait.until(ExpectedConditions.titleIs("Sign in"));
        return getTitle(getDriver());
    }
}
