package drivers;

import browsers.Chrome;
import browsers.Firefox;
import browsers.IWebDriver;
import browsers.Safari;
import constant.EBrowserType;

public class WebDriverFactory {

  private WebDriverFactory() {

  }

  public static IWebDriver getWebDriver(EBrowserType browserType) {
    switch (browserType) {
      case CHROME:
        return new Chrome();
      case FIREFOX:
        return new Firefox();
      case SAFARI:
        return new Safari();
      default:
        throw new IllegalArgumentException(
            "The webDriverType " + browserType + " is not supported!");
    }
  }


}
