package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

  @FindBy(css = "span[class='title']")
  private WebElement lbProducts;

  public ProductPage() {
  }

  @Step("this page is Products")
  public boolean isProductPage() {
    return lbProducts.isDisplayed();
  }
}
