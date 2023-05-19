package listener;

import drivers.WebDriverInstance;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  public void onTestStart(ITestResult result) {
    System.out.println("Start on test: " + result.getName());
  }

  public void onTestSuccess(ITestResult result) {
    System.out.println("Success on test: " + result.getName());
  }

  public void onTestFailure(ITestResult result) {
    takeScreenshot();
  }

  public void onTestSkipped(ITestResult result) {
    System.out.println("Test skipped: " + result.getName());
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  }

  public void onTestFailedWithTimeout(ITestResult result) {
    this.onTestFailure(result);
  }

  public void onStart(ITestContext context) {
    System.out.println("Start on context: " + context.getName());
  }

  public void onFinish(ITestContext context) {
    System.out.println("Finish on context: " + context.getName());
  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] takeScreenshot() {
    return ((TakesScreenshot) WebDriverInstance.getWebDriverInstance()).getScreenshotAs(
        OutputType.BYTES);
  }
}
