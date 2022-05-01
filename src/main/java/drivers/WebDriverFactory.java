package drivers;

import constant.EWebDriverType;

public class WebDriverFactory {
    public WebDriverFactory() {

    }

    public static final IWebDriver getDriverName(String webDriver) {
        switch (webDriver) {
            case "chrome":
                return new Chrome();
            case "fire_fox":
                return new Firefox();
            default:
                throw new IllegalArgumentException("The webDriverType " + webDriver + " is not supported!");
        }
    }
}
