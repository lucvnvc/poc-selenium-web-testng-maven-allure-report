# TestNG

### Annotations

### TestNG.xml

Examples:
**using class name**:
```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
  
<suite name="Suite1" verbose="1" >
  <test name="Nopackage" >
    <classes>
       <class name="NoPackageTest" />
    </classes>
  </test>
 
  <test name="Regression1">
    <classes>
      <class name="test.sample.ParameterSample"/>
      <class name="test.sample.ParameterTest"/>
    </classes>
  </test>
</suite>
```

**using package name instead of class**
```

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
 
<suite name="Suite1" verbose="1" >
  <test name="Regression1"   >
    <packages>
      <package name="test.sample" />
   </packages>
 </test>
</suite>
```

**You can also specify groups and methods to be included and excluded:**
```
<test name="Regression1">
  <groups>
    <run>
      <exclude name="brokenTests"  />
      <include name="checkinTests"  />
    </run>
  </groups>
  
  <classes>
    <class name="test.IndividualMethodsTest">
      <methods>
        <include name="testMethod" />
      </methods>
    </class>
  </classes>
</test>

```

### Run TestNG
TestNG can be invoked in different ways:
1. command line
2. ant
3. IDEA

**Run testNG by command line**
```
java org.testng.TestNG testng1.xml [testng2.xml testng3.xml ...] [options]
```
**options**
```
-configfailurepolicy: skip - default|continue
-d: The directory where the reports will be generated (defaults to test-output).
-listener
-methods
-parallel: methods|tests|classes
-reporter
-suitename
-testname
...
```

### Parameters
There are three ways to set these parameters
1. The testng.xml file
2. Programmatically
3. Java system properties

### Factory
Example:
```
public class WebTestFactory {
  @Factory
  public Object[] createInstances() {
   Object[] result = new Object[10]; 
   for (int i = 0; i < 10; i++) {
      result[i] = new WebTest(i * 10);
    }
    return result;
  }
}
```

### Parallel
The parallel attribute on the <suite> tag can take one of following values: `methods`, `tests`, `classes`, and `instances`

### Retry
> Every time tests fail in a suite, TestNG creates a file called testng-failed.xml in the output directory

**Sometimes, you might want TestNG to automatically retry a test whenever it fails. In those situations, you can use a retry analyzer**
Here is how you use a retry analyzer:
```
1. Build an implementation of the interface org.testng.IRetryAnalyzer
2. Bind this implementation to the @Test annotation for e.g., @Test(retryAnalyzer = LocalRetry.class)

```

## TestNG Listeners

```
There are several interfaces that allow you to modify TestNG's behavior. These interfaces are broadly called "TestNG Listeners". Here are a few listeners:
- IAnnotationTransformer (doc, javadoc)
- IAnnotationTransformer2 (doc, javadoc)
- IHookable (doc, javadoc)
- IInvokedMethodListener (doc, javadoc)
- IMethodInterceptor (doc, javadoc)
- IReporter (doc, javadoc)
- ISuiteListener (doc, javadoc)
- ITestListener (doc, javadoc)
```

#### How to use listeners
- Using -listener on the cli
- Using <listeners> with ant
- Using <listeners> in your testng.xml file
- Using the @Listeners annotation on any of your test classes
- Using ServiceLoader

## Test results

### Success, failure and assert

## YAML

## Dry Run

## Logging
Prior to TestNG version 7.5, TestNG supports logging via a custom logging framework similar to Log4j
Starting from TestNG version 7.5 TestNG makes use of the logging facade provided by Slf4j.