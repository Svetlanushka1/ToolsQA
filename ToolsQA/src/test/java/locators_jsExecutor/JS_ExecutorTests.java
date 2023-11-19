package locators_jsExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class JS_ExecutorTests {



        WebDriver driver;
        @BeforeClass
        public void preconditions() {
            driver = new ChromeDriver();
            driver.navigate().to("https://demoqa.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @AfterClass
        public void postConditions() {
            driver.quit();
        }

        @Test
        public void clickTest() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('h5').click();");
            Thread.sleep(5000);
        }


    }
