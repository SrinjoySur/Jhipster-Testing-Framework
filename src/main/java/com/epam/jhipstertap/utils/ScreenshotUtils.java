package com.epam.jhipstertap.utils;

import com.epam.jhipstertap.constants.ConfigProvider;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class ScreenshotUtils {
    private static volatile TakesScreenshot screenshot;
    private static int count=0;
    @SneakyThrows
    public static void saveScreenshot(WebDriver driver){
        count++;
        screenshot=(TakesScreenshot) driver;
        File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile=new File(ConfigProvider.getScreenshotsDirPath()+"/failure"+count+"_screenshot.png");
        FileHandler.copy(srcFile,destFile);
    }
    public static int getCount(){
        return count;
    }
}
