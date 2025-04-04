package com.epam.utils;

import java.io.File;
import java.util.Properties;

public class ConfigReader {
    private File config=new File(System.getProperty("user.dir")+"src/main/resources/config.properties");
    Properties properties=new Properties();
}
