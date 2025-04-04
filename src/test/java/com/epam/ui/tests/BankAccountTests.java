package com.epam.ui.tests;

import com.epam.ui.pages.BankAccountPage;
import com.epam.ui.pages.Jhipster_Logged_In_HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class BankAccountTests extends LoginTest{
    @Test(testName = "BankAccountPageRedirection", priority = 3)
    @Description("Test Description : Redirects to Bank Account Page")
    @Story("Successful Redirection to Bank Account Page")
    @Step("Redirects to Bank Account Page")
    void testBankAccountPageRedirection(){
        Jhipster_Logged_In_HomePage loggedInHomePage = new Jhipster_Logged_In_HomePage(driver);
        loggedInHomePage.goToBankAccountPage();
        assertEquals(loggedInHomePage.verifyTitle(),"JhipsterSampleApplication");
    }
    @Test(testName = "BankAccountCreation", priority = 4)
    @Parameters({"name","balance","user"})
    @Description("Test Description : Creates New Bank Account")
    @Story("Successful Creates New Bank Account")
    @Step("Creates a New Bank Account")
    void testBankAccountCreation(String name,String balance,String user){
        BankAccountPage bankAccountPage = new BankAccountPage(driver);
        bankAccountPage.createEntity(name,balance,user);
        String actual= bankAccountPage.verifyEntityCreated(name);
        assertEquals(actual,name);
    }
}
