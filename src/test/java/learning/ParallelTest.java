package learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTest {
  @Test
  public void test01() {
    System.out.println("test 01");
  }

  @Test
  public void test02() {
    System.out.println("test 02");
  }

  @Test
  public void test03() {
    System.out.println("test 03");
  }

  @Test
  public void test04() {
    System.out.println("test 04");
  }

  @Test
  public void test05() {
    Assert.assertEquals(10, 5);
    System.out.println("test 05");
  }

  @Test
  public void test06() {
    System.out.println("test 06");
  }

}
