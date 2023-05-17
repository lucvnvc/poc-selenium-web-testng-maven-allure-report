package drivers;

import constant.EBrowserType;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class WebDriverInstance {

  private static WebDriver driver;

  private static Map<Long, WebDriver> map = new HashMap<Long, WebDriver>();

  public static WebDriver getWebDriverInstance() {
    return map.get(Thread.currentThread().getId());
  }

  public static WebDriver start(EBrowserType browserType) {
    driver = WebDriverFactory.getWebDriver(browserType).getWebDriver();
    map.put((Thread.currentThread().getId()), driver);
    return driver;
  }

  public static void stop() {
    if (driver != null) {
      driver.manage().deleteAllCookies();
      driver.quit();
    }
  }
}
