package com.epam.constants;

public class ConfigProvider {
    private static final String configPath= System.getProperty("user.dir")+"src\\main\\ui\\resources\\config.properties";
    public static String getConfigPath() {
        return configPath;
    }
}
