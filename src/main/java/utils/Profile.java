package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import models.WebCapability;

public class Profile {

  private static final WebCapability webCapability = new WebCapability();
  private static final Profile instance = new Profile();

  private Profile() {

  }

  public static Profile createInstance() {
    return instance;
  }

  public WebCapability getEnvironmentVariables() {
    return webCapability;
  }

  public void setEnvironmentVariables(String fileName) {
    InputStream conf = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    if (conf == null) {
      throw new IllegalArgumentException(
          "The file " + fileName + " not found in 'resources' folder");
    }
    Properties properties = new Properties();
    try {
      properties.load(conf);
      webCapability.setBaseUrl(properties.getProperty("baseUrl"));
      webCapability.setWebDriver(properties.getProperty("webDriver"));
    } catch (IOException ex) {
      throw new IllegalArgumentException(
          "Unable to read the file " + fileName + " in 'resources' folder");
    }
  }
}
