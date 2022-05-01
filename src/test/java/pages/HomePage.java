package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "uid")
    private WebElement weUser;
    @FindBy(name = "password")
    private WebElement wePassword;
    @FindBy(name = "btnLogin")
    private WebElement btnLogin;

    @Step("the user set an user")
    public void setUser(String user) {
        waitVisibilityOf(weUser);
        weUser.sendKeys(user);
    }

    @Step("the user set a password")
    public void setPassword(String password) {
        waitVisibilityOf(wePassword);
        wePassword.sendKeys(password);
    }

    @Step("the user click on the Submit")
    public void submit() {
        waitToClickAble(btnLogin);
        btnLogin.click();
    }
}
