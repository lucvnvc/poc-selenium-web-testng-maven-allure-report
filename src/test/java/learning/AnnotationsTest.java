package learning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(groups = {"AnnotationTest"})
public class AnnotationsTest {

  /***
   * Marks a method as supplying data for a test method. The annotated method must return an Object[][] where each Object[] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.
   * Attributes: name, parallel
   */
  @DataProvider(name = "userInfo")
  public Object[][] getUserInfo() {
    return new Object[][] {
        { "Cedric", 36 },
        { "Anne",37 },
    };

  }

  /**
   * Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[].
   * @return
   */
  @Factory
  public Object[] geta() {
    return null;
  }

  /**
   * Defines listeners on a test class.
   * Attributes: value - An array of classes that extend org.testng.ITestNGListener.
   */
//  @Listeners
//  public void listeners() {
//
//  }

  /**
   * Describes how to pass parameters to a @Test method.
   * Attribute: value - The list of variables used to fill the parameters of this method.
   */
  @Parameters()
  public void parameters() {

  }

  /**
   * Marks a class or a method as part of the test.
   * Attributes: alwaysRun, dataProvider, dependsOnMethods, description, enabled, groups, ...
   */
  @Test(dataProvider = "userInfo", groups = {"test01", "testLogin"})
  public void test01() {
    System.out.println("this is test");
  }
  @BeforeSuite
  public void beforeSuite() {
    System.out.println("run before all tests in this suite have run");
  }

  @BeforeTest
  public void beforeTest() {
    System.out.println("Before Test");
  }

  @BeforeGroups(alwaysRun = true)
  public void beforeGroup() {
    System.out.println("Before Group");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println("Before Class");
  }

  @BeforeMethod
  public void beforeMethod() {
    System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("After Method");
  }

  @AfterClass
  public void afterClass() {
    System.out.println("After Class");
  }

  @AfterGroups(alwaysRun = true)
  public void afterGroup() {
    System.out.println("After Group");
  }

  @AfterTest
  public void afterTest() {
    System.out.println("After Test");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("run after all tests in this suite have run");
  }
}
