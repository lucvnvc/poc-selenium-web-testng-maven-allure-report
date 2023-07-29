package pages;

import drivers.WebDriverInstance;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
  protected static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
  private static final int UNIT_TIMEOUT = 30;

  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage() {
    driver = WebDriverInstance.getWebDriverInstance();
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(UNIT_TIMEOUT));
  }

  public void waitForElementVisibilityOf(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForElementToClickAble(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  protected void waitForElementInvisibilityOf(WebElement element) {
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  protected void waitAttributeContains(WebElement element, String attribute, String value) {
    wait.until(ExpectedConditions.attributeContains(element, attribute, value));
  }

  protected Boolean isElementCSSContainsValue(WebElement element, String css, String value) {
    return element.getCssValue(css).contains(value);
  }

  protected WebElement scrollDownToElement(WebElement element, int retry) {
    int currentTry = 1;
    while(currentTry < retry) {
      try {
        if (element.isDisplayed()) {
          LOGGER.info("Retry number: " + currentTry + " >>> Given element is visible.");
          //to avoid overlap with page footer
          smallScroll("Down");
          return element;
        } else {
          LOGGER.info("Retry number: " + currentTry + " >>> Given element is NOT visible.");
          scroll("Down");
          currentTry++;
        }
      } catch (NoSuchElementException e) {
        LOGGER.info("Retry number: " + currentTry + " >>> Unable to find given element.");
        currentTry++;
        scroll("Down");
      }
    }
    throw new NoSuchElementException("Cannot find given element: " + element + "\nRetry: " + retry + "\n");
  }

  protected WebElement scrollUpToElement(WebElement element, int retry) {
    int currentTry = 1;
    while(currentTry < retry) {
      try {
        if (element.isDisplayed()) {
          LOGGER.info("Retry number: " + currentTry + " >>> Given element is visible.");
          //to avoid overlap with page footer
          smallScroll("Up");
          return element;
        } else {
          LOGGER.info("Retry number: " + currentTry + " >>> Given element is NOT visible.");
          scroll("Up");
          currentTry++;
        }
      } catch (NoSuchElementException e) {
        LOGGER.info("Retry number: " + currentTry + " >>> Unable to find given element.");
        currentTry++;
        scroll("Up");
      }
    }
    throw new NoSuchElementException("Cannot find given element: " + element + "\nRetry: " + retry + "\n");
  }

  private void scroll(String direction) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    switch (direction.toLowerCase()) {
      case "up":
        js.executeScript("javascript:window.scrollBy(250,0)");
        break;
      case "down":
        js.executeScript("javascript:window.scrollBy(0,250)");
        break;
      default:
        throw new IllegalArgumentException("direction: '" + direction + "' is not supported. Try 'Down', 'Up'.");
    }
  }

  private void smallScroll(String direction) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    switch (direction.toLowerCase()) {
      case "up":
        js.executeScript("javascript:window.scrollBy(150,0)");
        break;
      case "down":
        js.executeScript("javascript:window.scrollBy(0,150)");
        break;
      default:
        throw new IllegalArgumentException("direction: '" + direction + "' is not supported. Try 'Down', 'Up'.");
    }
  }

  protected void scrollElementIntoView(WebElement element) {
    try {
      if (element.isDisplayed()) {
        LOGGER.info("Given element is already in view port");
      } else {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
      }
    } catch (NoSuchElementException ignored) {
    }
  }

  protected boolean waitForPageLoad() {
    return wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
  }
}
