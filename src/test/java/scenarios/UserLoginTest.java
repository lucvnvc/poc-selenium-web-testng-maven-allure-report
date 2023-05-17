package scenarios;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.ProductPage;

public class UserLoginTest extends BaseTest {

  private ProductPage productPage;

  @Test
  @Description("The user is login success")
  public void login_success_with_user_and_pass() {
    productPage = loginPage.setUsername("standard_user").setPassword("secret_sauce")
        .clickOnLoginWithValidUser();
//    assertThat(productPage.isProductPage(), true);
//    assertThat("File name should exist", file.exists(), is(equalTo(true)));
//    assertThatproductPage.isProductPage();
  }

  @Test
  @Description("The user is login fail")
  public void login_fail_with_user_and_pass() {
    productPage = loginPage.setUsername("standard_user1").setPassword("secret_sauce1")
        .clickOnLoginWithValidUser();
    Assert.assertTrue(productPage.isProductPage());
  }

  @Test()
  @Description("This test is skipped")
  public void test_skipped() {
    throw new SkipException("Skipped");
  }
}
