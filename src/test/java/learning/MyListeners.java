package learning;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

  public void onTestStart(ITestResult result) {
    System.out.println("Start test: " + result.getMethod());
  }

  public void onTestSuccess(ITestResult result) {
    System.out.println("Test success: " + result.getMethod());
  }

  public void onTestFailure(ITestResult result) {
    System.out.println("Test failed: " + result.getTestName());
  }

  public void onTestSkipped(ITestResult result) {
    System.out.println("Test skipped: " + result.getTestName());
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  }

  public void onTestFailedWithTimeout(ITestResult result) {
    this.onTestFailure(result);
  }

  public void onStart(ITestContext context) {
    System.out.println("Start: " + context.getName());
  }

  public void onFinish(ITestContext context) {
    System.out.println("Finish: " + context.getName());
  }

}
