package com.epam.ui.pages;

import com.epam.ui.basepages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import static com.epam.ui.utils.CommonUtils.*;

public class BankAccountPage extends BasePage {
    public BankAccountPage(WebDriver driver){
        super(driver);
    }
    Wait<WebDriver> wait=getWait(120);
    private final By createNewBankAccount=By.id("jh-create-entity");
    private final By bankAccountCreateHeader=By.id("jhi-bank-account-heading");
    private final By nameField=By.id("field_name");
    private final By balanceField=By.id("field_balance");
    private final By userField=By.id("field_user");
    private final By saveButton=By.id("save-entity");
    public WebDriver createEntity(String name,String balance,String user){
        WebElement createNewBankAccountButton=findWebElement(getDriver(),createNewBankAccount);
        click(createNewBankAccountButton);
        WebElement nameElement=findWebElement(getDriver(),nameField);
        sendKeys(nameElement,name);
        WebElement balanceElement=findWebElement(getDriver(),balanceField);
        sendKeys(balanceElement,balance);
        WebElement userElement=findWebElement(getDriver(),userField);
        Select select=new Select(userElement);
        select.selectByVisibleText(user);
        WebElement saveButtonElement=findWebElement(getDriver(),saveButton);
        click(saveButtonElement);
        return getDriver();
    }
    public String verifyEntityCreated(String name){
        By entity=By.xpath("//div[@id='entities']//td[text()='"+name+"']");
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(entity));
        return getText(element);
    }
}
