package pages;

import drivers.WebDriverInstance;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage() {
    driver = WebDriverInstance.getWebDriverInstance();
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  }

  public void waitVisibilityOf(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitToClickAble(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }
}
