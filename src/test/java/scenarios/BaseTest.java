package scenarios;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import com.google.common.collect.ImmutableMap;
import constant.EBrowserType;
import drivers.WebDriverInstance;
import io.qameta.allure.Allure;
import models.WebCapability;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
    driver = WebDriverInstance.start(
        EBrowserType.valueOf(webCapability.getWebDriver().toUpperCase()));
    driver.get(webCapability.getBaseUrl());
    driver.manage().window().maximize();
    loginPage = new LoginPage();
  }

  @BeforeMethod
  public void beforeMethod(ITestContext context) {
    Allure.addAttachment("Start on test: ", context.getName());
  }

  @AfterTest
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
    Allure.addAttachment("End on test: ", result.getName());
  }

  @AfterSuite
  public void afterSuite() {
    setAllureEnvironment();
  }

  private void setAllureEnvironment() {
    allureEnvironmentWriter(
        ImmutableMap.<String, String>builder()
            .put("Browser",
                ((RemoteWebDriver) WebDriverInstance.getWebDriverInstance()).getCapabilities()
                    .getBrowserName())
            .put("Browser.Version",
                ((RemoteWebDriver) WebDriverInstance.getWebDriverInstance()).getCapabilities()
                    .getBrowserVersion())
            .put("PlatformName",
                ((RemoteWebDriver) WebDriverInstance.getWebDriverInstance()).getCapabilities()
                    .getPlatformName().toString())
            .put("URL", Profile.createInstance().getEnvironmentVariables().getBaseUrl())
            .build(), System.getProperty("user.dir")
            + "/target/allure-results/");
  }
}
