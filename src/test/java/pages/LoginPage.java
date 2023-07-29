package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  // define locator
  @FindBy(id = "user-name")
  private WebElement weUser;
  @FindBy(id = "password")
  private WebElement wePassword;
  @FindBy(name = "login-button")
  private WebElement btnLogin;

  public LoginPage() {
    LOGGER.info("This is Login page");
  }

  // methods
  @Step("the user set an username")
  public LoginPage setUsername(String user) {
    waitForElementVisibilityOf(weUser);
    weUser.clear();
    weUser.sendKeys(user);
    return this;
  }

  @Step("the user set a password")
  public LoginPage setPassword(String password) {
    waitForElementVisibilityOf(wePassword);
    wePassword.clear();
    wePassword.sendKeys(password);
    return this;
  }

  @Step("the user click on the Login")
  public ProductPage clickOnLoginWithValidUser() {
    waitForElementToClickAble(btnLogin);
    btnLogin.click();
    return new ProductPage();
  }
}
