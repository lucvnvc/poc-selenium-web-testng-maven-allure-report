package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari implements IWebDriver{

  @Override
  public WebDriver getWebDriver() {
    WebDriverManager.safaridriver().setup();
    return new SafariDriver();
  }
}
