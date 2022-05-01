package scenarios;

import drivers.WebDriverFactory;
import models.SeleniumWeb;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import utils.Profile;

public class BaseTest {
    WebDriver driver;
    protected HomePage homePage;

    @BeforeSuite
    public void setEnvironment() {
        final String envVariable = System.getProperty("properties");
        if (envVariable == null) {
            Profile.createInstance().setEnvironmentVariables("chrome.properties");
        } else {
            Profile.createInstance().setEnvironmentVariables(envVariable);
        }
    }

    @BeforeMethod
    public void setUp() {
        SeleniumWeb seleniumWeb = Profile.createInstance().getEnvironmentVariables();
        driver = getDriver(seleniumWeb.getWebDriver());
        driver.get(seleniumWeb.getBaseUrl());
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver == null) {
            return;
        } else {
            driver.quit();
        }
    }

    private WebDriver getDriver(String webDriver) {
        return WebDriverFactory.getDriverName(webDriver).getDriver();
    }
}
