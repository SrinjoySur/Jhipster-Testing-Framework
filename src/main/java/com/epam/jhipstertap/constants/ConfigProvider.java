package com.epam.jhipstertap.constants;

public class ConfigProvider {
    private static final String configPath= "src/main/resources/config.properties";
    public static String getConfigPath() {
        return configPath;
    }
}
