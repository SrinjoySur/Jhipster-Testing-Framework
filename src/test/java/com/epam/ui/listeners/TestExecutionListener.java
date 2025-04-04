package com.epam.ui.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.epam.ui.basetest.BaseTest;

public class TestExecutionListener implements ITestListener {
    private final BaseTest baseTest=new BaseTest();
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
//    @Override
//    public void onTestSuccess(ITestResult result){
//        saveScreenshot(result.getName(),baseTest.driver);
//    }
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result.getName(),baseTest.driver);
    }

}