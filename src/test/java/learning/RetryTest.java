package learning;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {

  @Test(retryAnalyzer = MyRetry.class)
  public void testRetry() {
    Assert.fail();
  }

  @Test(retryAnalyzer = MyRetry.class)
  public void testRetry02() {
    System.out.println("Khong phai retry");
  }

}
