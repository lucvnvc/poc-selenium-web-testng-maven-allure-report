package learning;

import io.qameta.allure.Attachment;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListeners implements ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    System.out.println("Start suite name >> " + suite.getName());
  }

  @Attachment(value = "{0}", type = "text/plain")
  @Override
  public void onFinish(ISuite suite) {
    System.out.println("Finish suite name >> " + suite.getName());
  }

}
