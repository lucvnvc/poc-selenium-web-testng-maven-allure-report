package learning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
  @DataProvider(name = "userInfo")
  public Object[][] getUserInfo() {
    return new Object[][] {
        {"Luc"},
        {"Thanh"},
    };
  }

  @Test(dataProvider = "userInfo")
  public void dataProviderTest(String user) {
    System.out.println("Ten: " + user);
  }

}
