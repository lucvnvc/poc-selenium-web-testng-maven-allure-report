package utils;

import models.SeleniumWeb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Profile {
    private static SeleniumWeb seleniumWeb = new SeleniumWeb();
    private static Profile instance = new Profile();

    private Profile() {

    }

    public static Profile createInstance() {
        return instance;
    }

    public void setEnvironmentVariables(String fileName) {
        InputStream conf = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        if (conf == null) {
            throw new IllegalArgumentException("The file " + fileName + " not found in 'resources' folder");
        }
        Properties properties = new Properties();
        try {
            properties.load(conf);
            seleniumWeb.setBaseUrl(properties.getProperty("baseUrl"));
            seleniumWeb.setWebDriver(properties.getProperty("webDriver"));
        } catch (IOException ex) {
            throw new IllegalArgumentException("Unable to read the file " + fileName + " in 'resources' folder");
        }
    }

    public SeleniumWeb getEnvironmentVariables() {
        return seleniumWeb;
    }
}
