package scenarios;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {
    @Test
    @Description("The user is login success")
    public void login_fail_with_user_and_pass() {
        homePage.setUser("AAA");
        homePage.setPassword("BBBB");
        homePage.submit();
    }
}
