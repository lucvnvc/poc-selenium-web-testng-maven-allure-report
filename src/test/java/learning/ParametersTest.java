package learning;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
  @Parameters({"user-name"})
  @Test
  public void testWithParameters(String user) {
    System.out.println("User name is: " + user);
  }

}
