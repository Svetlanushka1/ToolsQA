### [TestNG Overview](src/main/java/...)

- [TestNG Home site](https://testng.org/doc/)
- [Selenium and TestNG](https://testng.org/doc/selenium.html)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- Additional info: [Course TestNG by QA Automation и SDET](https://www.youtube.com/watch?v=xx0CYt03_bc&list=PLABk5HoxRaQIk89RgVhlaP3v7r21jJ4Qg)

* Basics of TestNG
* - Data Driven
* - Annotations
* - Attributes


* Steps to create and run tests:
* - Write the business logic of your test and insert TestNG annotations in your code.
* - Add the information about your test (e.g. the class name, the groups you wish to run, etc...) in a testng.xml file or in build.xml.
* - Run TestNG.

____
* TestNG Annotations
<br> Annotation is a label that provides additional information about a class
or method. The prefix “@” is used for annotations. TestNG uses annotations,
to help create a robust test structure.<br>

![hierarchy-of-testng-annotations.jpg](src%2Fhierarchy-of-testng-annotations.jpg)
* __<span style="color:red">@BeforeSuite</span>__: the annotated method will be run before
all tests in this suite have been run.
* __<span style="color:red">@AfterSuite</span>__: the annotated method will run eventually
tests in this set.
* __<span style="color:red">@BeforeClass</span>__ : the annotated method will be run before the first one is called
test method in the current class.
* __<span style="color:red">@AfterClass</span>__ : the annotated method will be run after
all testing methods in the current class are running.
* __<span style="color:red">@BeforeMethod</span>__ : the annotated method will be run before each
test method.
* __<span style="color:red">@AfterMethod</span>__ : the annotated method will be run after every
testing method.
* __<span style="color:red">@BeforeTest</span>__ : the annotated method will be run before any
test method belonging to the classes inside the tag <test>.
* __<span style="color:red">@AfterTest</span>__ : the annotated method will be run after
all testing methods belonging to classes inside the tag <test>are launched
.
* __<span style="color:red">@BeforeGroups</span>__ : list of groups that this configuration method will
launch earlier. This method is guaranteed to run shortly before
calling the first test method belonging to any of these groups.
* __<span style="color:red">@AfterGroups</span>__: list of groups after which this method will be executed
settings. This method is guaranteed to run shortly after being called
last test method belonging to any of these groups.


___
* TestNG Attributes

![testng-annotation-attributes.png](src%2Ftestng-annotation-attributes.png)

* __<span style="color:red">description</span>__: You can specify a description of the test method.
<br> For example, @Test(description=”this test tests login”). <hr>

* __<span style="color:red">alwaysRun</span>__: this attribute ensures that the test method will always be executed,
even in the fall of the trials on which he depends. If the attribute value is true,
this method will always run. <br>For example, @Test(alwaysRun= true). <hr>

* __<span style="color:red">dataProvider</span>__: specifies the name of the DataProvider for the method.
If you're going to run your tests in multiple browsers,
then in the test method with the "dataProvider" attribute, you can add parameters for
Browser and its version. In this case, a test containing this attribute would be
use this input to run tests in multiple browsers.
<br>For example, @Test(dataProvider=”cross-browser-testing”). <hr>

* __<span style="color:red">dependsOnMethods</span>__: provides information about the order in which tests are run. Test
(with this attribute) will only be executed if the test from
which he depends on. If a test that a method depends on fails, then Test
(with this attribute) will not
run. <br>For example, @Test (depenOnmethod = “login”). <hr>


* __<span style="color:red">groups</span>__: helps you group your test methods that focus on one
functionality into one group..
<br>For example, @Test(groups={”Payment_Module”}).
This attribute also allows you to control which tests to run. When running tests
you can ignore some groups or, conversely, run only some groups.
Here you need to specify the required groups in the TestNG.xml file. In the include tag, indicate the groups
which need to be run, and in the exclude tag which should be ignored. <hr>

* __<span style="color:red">priority</span>__: helps determine the priority of test methods. When TestNG executes
test methods, it can do this in any order. In a scenario where you
want your tests to run in the order you want, you can use
priority attribute. The default priority for all test methods is 0. First
tests with a lower priority value are executed.
<br>For example, @Test (priority = 1), @Test (priority = 2).In this case, it will be executed first
a test with priority =1, and then a test with priority= 2.TestNG attributes
 <hr>

* __<span style="color:red">enabled</span>__: this attribute is used when you need to ignore and not run
certain test. All you have to do is set it to false.
<br>For example, @Test(enabled= false). <hr>

* __<span style="color:red">timeout</span>__: defines the time in which the test should be executed. If execution
test exceeds the time specified by the attribute, the test will fail with an error with
throwing an exception(org.testng.internal.thread.ThreadTimeoutException). <br>For example,
@Test(timeOut= 500). Please note that the time is in milliseconds.
 <hr>

* __<span style="color:red">invocationCount</span>__: works exactly the same as a loop. The test will be run as many times as
how much is indicated in invocationCount. <br>Например, @Test(invocationCount = 5), will
ran 5 times.TestNG Attributes <hr>

* __<span style="color:red">invocationTimeOut</span>__: used together with attribute
"invocationCount". The value of this attribute together with "invocationCount" indicates whether
that the test will be run as many times as specified in "invocationCount", and for
time specified in the attribute "invocationTimeOut".
<br>For example, @Test(invocationCount = 5, invocationTimeOut = 20). <hr>

* __<span style="color:red">expectedExceptions</span>__: 
helps handle exceptions that are expected to be thrown
in the test method. If the exception specified in the attribute is thrown by the test
method, the test was successful. Otherwise, the test will fail if there is no exception or
there will be another exception not specified in the attribute.
<br>For example: <br>_@Test(expectedExceptions = {ArithmeticException.class })_. <hr>


* DataProviders
```java
    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;
```
```java
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][] {
            {"username1", "password1"},
            {"username2", "password2"},
            {"username3", "password3"}
        };
    }
```
```java
    @Test(dataProvider = "testData")
    public void loginTest(String username, String password) {
        System.out.println("Logging in with username: " + username + ", password: " + password);
        // Your test logic goes here
    }
```

* Some commonly used assertion methods in TestNG
* - Assert.assertTrue
```java
    int result = 2 + 2;
    Assert.assertTrue(result == 4, "Expected result to be 4, but found " + result);
```

* - assertFalse
```java
    int result = 2 + 2;
    Assert.assertFalse(condition, message);
```

* - assertEquals
```java
    int result = 2 + 2;
    Assert.assertEquals(result, 4, "Expected result to be 4, but found " + result);
```




build.gradle dependence for running test form difference Xml files
```
task reg(type: Test){
    useTestNG {
    def suite = System.getProperty('suite', '')
        if (suite.equals('quick')) {
            suites 'src/test/resources/quick.xml'
        } else if (suite.equals('smoke')) {
            suites 'src/test/resources/smoke.xml'
        } else {
            suites 'src/test/resources/testng.xml'
        }
        if (project.hasProperty('browser')) {
            systemProperty 'browser', "${browser}"
        }
    }
}
```

* Parallel tests
```java
    @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
```

* The graphical result can be found in the folder <br>
build->reports->tests->reg->index.html

* Example

BinarySearch Algorithm

![BinarySearch Algorithm](src%2F1_0OJ3eF9eO3FlPl5A_RtCSw.png)
```java
public class BinarySearch {
    public int binarySearch(int[] arr, int x)
	{
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			// Check if x is present at mid
			if (arr[m] == x)
				return m;

			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		// If we reach here, then element was
		// not present
		return -1;
	}
```

Test:
```java
@Test(groups = {"perftest", "checkintest"}, dataProvider = "testDataTime", priority = 1, threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
public void testArr1000Perf(int arr_size, int x, int expected_time, Method method) {
    BinarySearch bs = new BinarySearch();
    int[] arr = new int[arr_size + 1];
    for (int z = 0; z <= arr_size; z++) {
        arr[z] = z;
    }
    long start = System.nanoTime();
    bs.binarySearch(arr, 5);
    long end = System.nanoTime();
    long diff = end - start;
    System.out.println(start + " " + end + " " + diff);
    Assert.assertTrue(diff < expected_time, "diff lower than expected");
    }
}
```

```java

@Test(groups = {"functest", "second-group"},dataProvider = "testData", description = "Functionality test")
public void testArr1000Func(int arr_size, int x, int expected_element) {
    int[] arr = new int[arr_size + 1];
    for (int z = 0; z <= arr_size; z++) {
        arr[z] = z;
    }
    BinarySearch ob = new BinarySearch();
    int result = ob.binarySearch(arr, x);
    Assert.assertEquals(result, expected_element);
}
```
