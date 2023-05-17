package scenarios;

import constant.EBrowserType;
import drivers.WebDriverInstance;
import models.WebCapability;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import utils.Profile;

public class BaseTest {

  protected LoginPage loginPage;
  WebDriver driver;

  @BeforeSuite
  public void setEnvironment() {
    final String envVariable = System.getProperty("properties");
    if (envVariable == null) {
      Profile.createInstance().setEnvironmentVariables("firefox.properties");
    } else {
      Profile.createInstance().setEnvironmentVariables(envVariable);
    }
  }

  @BeforeTest
  public void setUp() {
    WebCapability webCapability = Profile.createInstance().getEnvironmentVariables();
    driver = WebDriverInstance.start(EBrowserType.valueOf(webCapability.getWebDriver().toUpperCase()));
    driver.get(webCapability.getBaseUrl());
    driver.manage().window().maximize();
    loginPage = new LoginPage();
  }

  @AfterTest
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
