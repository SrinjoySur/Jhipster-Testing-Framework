package com.epam.ui.constants;


public class ConfigProvider {
    private static final String configPath= System.getProperty("user.dir")+"src\\main\\ui\\resources\\config.properties";
    private static final String invalidLoginExcel=System.getProperty("user.dir")+"src\\main\\ui\\resources\\InvalidLogin.xlsx";
    private static final String validLoginExcel=System.getProperty("user.dir")+"src\\main\\ui\\resources\\ValidLogin.xlsx";
    public static String getConfigPath() {
        return configPath;
    }
    public static String getInvalidLoginExcel() {
        return invalidLoginExcel;
    }
    public static String getValidLoginExcel() {
        return validLoginExcel;
    }
}
